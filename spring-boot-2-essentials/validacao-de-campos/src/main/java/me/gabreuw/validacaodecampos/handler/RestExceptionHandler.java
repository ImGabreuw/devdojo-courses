package me.gabreuw.validacaodecampos.handler;

import me.gabreuw.validacaodecampos.exception.BadRequestException;
import me.gabreuw.validacaodecampos.exception.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException exception) {
        BadRequestExceptionDetails badRequestExceptionDetails = BadRequestExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, Check the documentation")
                .details(exception.getMessage())
                .developerMessage(exception.getClass().getName())
                .build();

        return ResponseEntity
                .badRequest()
                .body(badRequestExceptionDetails);

    }

}
