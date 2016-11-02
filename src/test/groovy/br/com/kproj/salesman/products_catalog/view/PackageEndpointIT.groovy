package br.com.kproj.salesman.products_catalog.view

import br.com.kproj.salesman.infratest.AbstractIntegrationTest
import br.com.kproj.salesman.infratest.ClassReference
import br.com.kproj.salesman.infratest.SceneryLoaderHelper
import br.com.kproj.salesman.products_catalog.domain.model.saleables.SaleableUnitRepository
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Stepwise
import spock.lang.Unroll

import static br.com.kproj.salesman.infratest.SceneryLoaderHelper.scenery
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@Stepwise
@ClassReference(SaleableEndpoint)
class PackageEndpointIT extends AbstractIntegrationTest {

    private static final String PACKAGES_CREATED = "/products_catalog/packages-create.json";

    def MockMvc mockMvc

    @Autowired
    def WebApplicationContext webApplicationContext

    @Autowired
    def SaleableUnitRepository repository

    def setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build()
        SceneryLoaderHelper.load(PACKAGES_CREATED)
    }

    @Unroll
    def "Creating a package"() {

        def mvcResult = mockMvc.perform(post("/rs/saleables")
                .content(scenery("Criacao de saleable para pacote").getJson())
                .contentType(MediaType.APPLICATION_JSON)).andReturn()

        def jsonResult = mvcResult.getResponse().getContentAsString()
        def saleable = new JsonSlurper().parseText(jsonResult)

        def uri = "/rs/saleables/${saleable.item.id}/packages"

        def packageMvc = mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)).andReturn()

        def packageResult = new JsonSlurper().parseText(packageMvc.getResponse().getContentAsString())

        def packageExpected = new JsonSlurper().parseText(scenery("Json de pacote criado esperado").getJson())

        expect:
            packageResult.item.id == saleable.item.id
            packageResult.item.saleable.id == saleable.item.id
            packageResult.item.saleable.name == packageExpected.item.saleable.name
            packageResult.item.saleable.description == packageExpected.item.saleable.description
            packageResult.item.saleable.active == packageExpected.item.saleable.active
            packageResult.item.saleable.price == packageExpected.item.saleable.price
            packageResult.item.saleable.priceCost == packageExpected.item.saleable.priceCost
            packageResult.uri == uri
    }

}