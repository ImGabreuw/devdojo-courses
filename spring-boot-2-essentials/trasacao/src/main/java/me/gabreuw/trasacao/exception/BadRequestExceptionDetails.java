package me.gabreuw.trasacao.exception;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestExceptionDetails implements Serializable {

    private LocalDateTime timestamp;

    private String title;
    private String details;
    private String developerMessage;

    private Integer status;
}
