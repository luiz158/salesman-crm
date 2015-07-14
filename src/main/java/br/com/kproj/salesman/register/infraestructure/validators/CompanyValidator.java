package br.com.kproj.salesman.register.infraestructure.validators;

import br.com.kproj.salesman.infrastructure.entity.Company;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
import org.springframework.validation.Validator;


import javax.validation.*;
import java.util.Set;

@Component
public class CompanyValidator implements Validator, InitializingBean {

    private javax.validation.Validator validator;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Company.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> constraints = validator.validate(target);

        constraints.forEach(error ->
                errors.rejectValue("company." + error.getPropertyPath().toString(), error.getMessage()));


    }

    @Override
    public void afterPropertiesSet(){
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            this.validator = factory.getValidator();
        } catch(Exception e) {}

    }

}