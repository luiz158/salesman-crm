package br.com.kproj.salesman.infrastructure.repository;

import br.com.kproj.salesman.infra.AbstractIntegrationTest;
import br.com.kproj.salesman.infrastructure.entity.UserEntity;
import br.com.kproj.salesman.infrastructure.entity.sale.SalesOrderEntity;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static br.com.kproj.salesman.infrastructure.entity.builders.UserEntityBuilder.createUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ActDeliverySalesRepositoryIT extends AbstractIntegrationTest {

    @Autowired
    private WorkspaceUnitRepository repository;

    @Test
    public void shouldReturnOnlyItemsInActDelivery() {
        List<SalesOrderEntity> result = repository.findSalesOrderOutActDelivery();

        assertThat(result.size(), is(2));
        assertThat(result.get(0).getId(), is(3l));
        assertThat(result.get(1).getId(), is(4l));
    }

    @Test
    public void shouldReturnOnlyInActWithDistinctAndOrderingByDeliveryForecast() {
        List<SalesOrderEntity> result = repository.findSalesOrderNotInWorkspace();

        assertThat(result.size(), is(2));
        assertThat(result.get(0).getId(), is(2l));
        assertThat(result.get(1).getId(), is(1l));
    }

    @Test
    public void shouldReturnAllUsersWithActDeliverySigned() {
        List<UserEntity> users = repository.findUsersWithSignedDelivery();

        assertThat(users.size(), is(2));

        assertThat(users.contains(createUser(1l).build()), Matchers.is(Boolean.TRUE));
        assertThat(users.contains(createUser(2l).build()), Matchers.is(Boolean.TRUE));
    }

}