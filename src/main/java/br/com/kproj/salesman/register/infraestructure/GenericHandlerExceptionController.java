package br.com.kproj.salesman.register.infraestructure;

import br.com.kproj.salesman.infrastructure.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.oxm.ValidationFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@ControllerAdvice
public class GenericHandlerExceptionController {

    @ExceptionHandler(value={ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handlerValidatorException(Throwable throwable) {

        return new ModelAndView("errors/list", "errors", ((ValidationException)throwable).getErrors());
    }
}