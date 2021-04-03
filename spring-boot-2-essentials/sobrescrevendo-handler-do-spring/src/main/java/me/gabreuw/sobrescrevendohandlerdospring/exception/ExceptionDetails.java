package me.gabreuw.sobrescrevendohandlerdospring.exception;

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
