package br.com.fatecmc.springboot2.handler;

import br.com.fatecmc.springboot2.exception.BadRequestException;
import br.com.fatecmc.springboot2.exception.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException badRequestException){
        return  new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .developerMessage(badRequestException.getClass().getName())
                        .details(badRequestException.getMessage())
                        .title("Bad Request Exception, check the Documentation").build(), HttpStatus.BAD_REQUEST
        );
    }
}
