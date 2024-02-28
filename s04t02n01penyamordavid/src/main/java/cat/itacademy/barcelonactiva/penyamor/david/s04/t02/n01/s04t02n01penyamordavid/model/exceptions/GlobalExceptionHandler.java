package cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n01.s04t02n01penyamordavid.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FruitNotFoundException.class)
    public ResponseEntity<ErrorMessage> fruitNotFoundException(FruitNotFoundException ex) {

        ErrorMessage message = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

}
