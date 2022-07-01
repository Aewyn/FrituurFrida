package com.example.frituurfrida.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record ZoekOpLetterForm (@NotNull @Pattern(regexp =  "[a-zA-Z]") String beginLetter){
}
