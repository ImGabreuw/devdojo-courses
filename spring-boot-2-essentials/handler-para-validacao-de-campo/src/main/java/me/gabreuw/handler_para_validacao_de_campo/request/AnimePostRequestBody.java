package me.gabreuw.handler_para_validacao_de_campo.request;

import lombok.Getter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class AnimePostRequestBody {

    @NotEmpty(message = "The anime name cannot be empty")
    @NotNull(message = "The anime name cannot be null")
    private String name;

    @URL(message = "The URL is not valid")
    private String url;
}
