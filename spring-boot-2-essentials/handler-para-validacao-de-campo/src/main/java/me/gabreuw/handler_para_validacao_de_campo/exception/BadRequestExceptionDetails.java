package me.gabreuw.handler_para_validacao_de_campo.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails {

    private final LocalDateTime timestamp;

    private final Integer status;

    private final String title;
    private final String details;
    private final String developerMessage;

}
