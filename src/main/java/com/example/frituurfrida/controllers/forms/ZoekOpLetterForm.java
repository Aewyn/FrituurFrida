package com.example.frituurfrida.controllers.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public record ZoekOpLetterForm (@NotNull @Pattern(regexp =  "[a-zA-Z]") String beginLetter){
}
