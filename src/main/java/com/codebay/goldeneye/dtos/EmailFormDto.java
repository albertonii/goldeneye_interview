package com.codebay.goldeneye.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.Constants.GoldenConstant;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class EmailFormDto {
    @NotBlank
    @NotEmpty
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 20, message = "{validation.name.size.too_long}")
    private String name;

    @NotBlank
    @NotEmpty
    @Size(min = 2, message = "{validation.surname.size.too_short}")
    @Size(max = 30, message = "{validation.surname.size.too_long}")
    private String surname;

    @JsonProperty("department")
    private GoldenConstant.Departments department;

    @JsonProperty("office")
    private GoldenConstant.Offices office;
    
    private String endcom;

    public EmailFormDto() {
        this.name = "";
        this.surname = "";
        this.department = GoldenConstant.Departments.NONE;
        this.office = GoldenConstant.Offices.NONE;
    }

    public EmailFormDto(String name, String surname, GoldenConstant.Departments department, GoldenConstant.Offices office) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.office = office;
    }
}
