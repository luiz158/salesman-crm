package br.com.kproj.salesman.accounts.customers.application.impl;

import br.com.kproj.salesman.accounts.customers.application.AccountFacade;
import br.com.kproj.salesman.accounts.customers.domain.model.customer.Customer;
import br.com.kproj.salesman.accounts.customers.domain.model.customer.CustomerRepository;
import br.com.kproj.salesman.infrastructure.repository.BaseRepository;
import br.com.kproj.salesman.infrastructure.service.BaseModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseModelServiceImpl<Customer> implements AccountFacade {

    private CustomerRepository repository;

    @Autowired
    public AccountServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public BaseRepository<Customer, Long> getRepository() {
        return repository;
    }
}
