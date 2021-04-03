package me.gabreuw.handler_para_validacao_de_campo.handler;

import me.gabreuw.handler_para_validacao_de_campo.exception.BadRequestException;
import me.gabreuw.handler_para_validacao_de_campo.exception.BadRequestExceptionDetails;
import me.gabreuw.handler_para_validacao_de_campo.exception.ValidationExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException exception) {
        BadRequestExceptionDetails details = BadRequestExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, Check the documentation")
                .details(exception.getMessage())
                .developerMessage(exception.getClass().getName())
                .build();

        return ResponseEntity
                .badRequest()
                .body(details);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handleBadRequestException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception
                .getBindingResult()
                .getFieldErrors();

        String fields = fieldErrors.stream()
                .map(FieldError::getField)
                .collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ValidationExceptionDetails details = ValidationExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, Invalid fields")
                .details(exception.getMessage())
                .developerMessage(exception.getClass().getName())
                .fields(fields)
                .fieldsMessage(fieldsMessage)
                .build();

        return ResponseEntity
                .badRequest()
                .body(details);

    }

}
