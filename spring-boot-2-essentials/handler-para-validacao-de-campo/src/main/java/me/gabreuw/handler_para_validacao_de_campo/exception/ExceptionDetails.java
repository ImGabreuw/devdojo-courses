package me.gabreuw.handler_para_validacao_de_campo.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails implements Serializable {

    protected LocalDateTime timestamp;

    protected Integer status;

    protected String title;
    protected String details;
    protected String developerMessage;

}
