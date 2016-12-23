package br.com.kproj.salesman.assistants.calendar.view

import br.com.kproj.salesman.infratest.AbstractIntegrationTest
import br.com.kproj.salesman.infratest.ClassReference
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@ClassReference(ActivityEndpoint)
class ActivityEndpointIT extends AbstractIntegrationTest {

    def MockMvc mockMvc

    @Autowired
    def WebApplicationContext webApplicationContext


    def setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build()
    }

    @Unroll
    def "Should find activities calendar"() {
        given:
            def uri = "/rs/users/calendars/1/calendar-activities"
        when:
            def mvcResult = mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON)).andReturn()
            def resultJson = new JsonSlurper().parseText(mvcResult.response.contentAsString)
        then: "Should return all activities"
            mvcResult.response.status == HttpStatus.OK.value
            resultJson.items.size == 10
            resultJson.totalItems == 10
            resultJson.pageSize == 400
            resultJson.items[0].id == 1
            resultJson.items[0].title == "Title 1"
            resultJson.items[0].description == "Description 1"
            resultJson.items[0].location == "location 1"
            resultJson.items[0].start == "2015-02-10T02:00:00.000+0000"
            resultJson.items[0].end == "2015-02-15T02:00:00.000+0000"
            resultJson.items[0].allDay == true
            resultJson.items[0].links.size == 1

            resultJson.items[0].links[0].href == "/rs/users/calendars/calendar-activities/calendar-activities-contacts/1"
            resultJson.items[0].links[0].rel == "calendar-activities-contact"
    }


}
