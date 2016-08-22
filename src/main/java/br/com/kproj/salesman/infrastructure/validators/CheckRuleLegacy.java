package br.com.kproj.salesman.infrastructure.validators;

import br.com.kproj.salesman.infrastructure.entity.Identifiable;

@FunctionalInterface
public interface CheckRuleLegacy<T extends Identifiable> {

    Boolean check(T t);
}