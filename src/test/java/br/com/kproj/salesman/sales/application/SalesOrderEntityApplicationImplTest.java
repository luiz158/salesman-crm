package br.com.kproj.salesman.sales.application;

import br.com.kproj.salesman.infrastructure.entity.proposal.BusinessProposalEntity;
import br.com.kproj.salesman.infrastructure.entity.sale.SalesOrderEntity;
import br.com.kproj.salesman.infrastructure.events.messages.NewSalesOrderMessage;
import br.com.kproj.salesman.infrastructure.exceptions.ValidationException;
import br.com.kproj.salesman.infrastructure.repository.SalesOrderRepository;
import br.com.kproj.salesman.sales.infrastructure.generatebyproposal.convert.ProposalToSaleOrder;
import com.google.common.eventbus.EventBus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SalesOrderEntityApplicationImplTest {

    @InjectMocks
    private SalesOrderApplicationImpl application;

    @Mock
    private SalesOrderRepository repository;

    @Mock
    private ProposalToSaleOrder converter;

    @Mock
    private EventBus eventBus;

    @Captor
    private ArgumentCaptor<NewSalesOrderMessage> messageCaptor;

    @Test
    public void shouldRegisterBusinessProposal() {
        BusinessProposalEntity proposalMock = mock(BusinessProposalEntity.class);
        SalesOrderEntity salesOrderEntityMock = mock(SalesOrderEntity.class);
        SalesOrderEntity salesOrderEntitySavedMock = mock(SalesOrderEntity.class);

        given(repository.findByProposal(proposalMock)).willReturn(Optional.empty());
        given(converter.convert(proposalMock)).willReturn(salesOrderEntityMock);
        given(salesOrderEntityMock.isNew()).willReturn(Boolean.TRUE);
        given(repository.save(salesOrderEntityMock)).willReturn(salesOrderEntitySavedMock);

        SalesOrderEntity result = application.register(proposalMock);

        assertThat(result, sameInstance(salesOrderEntitySavedMock));
    }

    @Test
    public void shouldSendMessage() {
        BusinessProposalEntity proposalMock = mock(BusinessProposalEntity.class);
        SalesOrderEntity salesOrderEntityMock = mock(SalesOrderEntity.class);
        SalesOrderEntity salesOrderEntitySavedMock = mock(SalesOrderEntity.class);

        given(repository.findByProposal(proposalMock)).willReturn(Optional.empty());
        given(converter.convert(proposalMock)).willReturn(salesOrderEntityMock);
        given(salesOrderEntityMock.isNew()).willReturn(Boolean.TRUE);
        given(repository.save(salesOrderEntityMock)).willReturn(salesOrderEntitySavedMock);

        application.register(proposalMock);

        verify(eventBus).post(messageCaptor.capture());
        NewSalesOrderMessage message = messageCaptor.getValue();

        assertThat(message.getSalesOrderEntity(), sameInstance(salesOrderEntitySavedMock));
    }

    @Test(expected = ValidationException.class)
    public void shouldThrowExceptionWhenSalesOrderAlreadyExists() {
        BusinessProposalEntity proposalMock = mock(BusinessProposalEntity.class);
        SalesOrderEntity salesOrderEntityMock = mock(SalesOrderEntity.class);

        given(repository.findByProposal(proposalMock)).willReturn(Optional.of(salesOrderEntityMock));

        application.register(proposalMock);
    }
}