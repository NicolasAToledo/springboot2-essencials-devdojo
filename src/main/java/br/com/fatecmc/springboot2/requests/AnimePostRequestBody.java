package br.com.fatecmc.springboot2.requests;

import lombok.Data;


import javax.validation.constraints.NotEmpty;


@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "The anime name cannot be empty or null")
    private String name;
}
