package br.com.kproj.salesman.register.application;

import br.com.kproj.salesman.infrastructure.entity.*;
import br.com.kproj.salesman.infrastructure.entity.person.Person;

public interface RegisterService {

    Person register(Person client);

    User register(User user);

}
