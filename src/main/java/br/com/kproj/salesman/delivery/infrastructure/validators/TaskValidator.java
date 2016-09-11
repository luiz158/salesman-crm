package br.com.kproj.salesman.delivery.infrastructure.validators;

import br.com.kproj.salesman.infrastructure.entity.task.TaskEntity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

@Component
public class TaskValidator implements Validator, InitializingBean {

    private javax.validation.Validator validator;



    @Override
    public boolean supports(Class<?> clazz) {
        return TaskEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TaskEntity taskEntity = (TaskEntity) target;
        Set<ConstraintViolation<Object>> constraints = validator.validate(taskEntity);

        if (taskEntity.isNew()) {
             if (taskEntity.getDeadline().before(new Date())) {
                 errors.rejectValue("deadline", "task.deadline.invalid");
             }
        }

        constraints.forEach(error ->
                errors.rejectValue(error.getPropertyPath().toString(), error.getMessage()));

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            this.validator = factory.getValidator();
        } catch(Exception e) {}
    }
}
