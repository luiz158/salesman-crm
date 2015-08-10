package br.com.kproj.salesman.negotiation.infrastructure.validators;

import br.com.kproj.salesman.infrastructure.entity.proposal.ProposalProductItem;
import br.com.kproj.salesman.register.infrastructure.validators.EntityIDValidator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;

@Component
public class ProposalProductItemValidator implements Validator, InitializingBean {

    private javax.validation.Validator validator;

    @Autowired
    private EntityIDValidator idValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return ProposalProductItem.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProposalProductItem productItem = (ProposalProductItem) target;

        validator.validate(productItem)
                .forEach(error -> errors.reject(error.getMessage()));

        idValidator.validate(productItem.getProduct(), errors);

        if (productItem.getPrice() != null
                && productItem.getPrice().compareTo(BigDecimal.ZERO) > 0) {
            errors.reject("price", "proposal.product.price.is.valid");
        }

    }

    @Override
    public void afterPropertiesSet(){
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            this.validator = factory.getValidator();
        } catch(Exception e) {}

    }
}