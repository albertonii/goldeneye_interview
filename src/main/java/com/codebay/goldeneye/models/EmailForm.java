package com.codebay.goldeneye.models;

import java.io.Serializable;

import com.Constants.GoldenConstant;
import com.codebay.goldeneye.dtos.EmailFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class EmailForm implements Serializable {
    private String name;
    private String surname;
    private GoldenConstant.Departments department;
    private GoldenConstant.Offices office;

    public EmailForm() {
        this.name = "";
        this.surname = "";
        this.department = GoldenConstant.Departments.NONE;
        this.office = GoldenConstant.Offices.NONE;
    }

    public EmailForm(String name, String surname, GoldenConstant.Departments department, GoldenConstant.Offices office) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.office = office;
    }

    public EmailForm(EmailFormDto emailFormDto) {
        this.name = emailFormDto.getName();
        this.surname = emailFormDto.getSurname();
        this.department = emailFormDto.getDepartment();
        this.office = emailFormDto.getOffice();
    }
}
