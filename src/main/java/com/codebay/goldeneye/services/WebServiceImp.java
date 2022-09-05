package com.codebay.goldeneye.services;


import org.springframework.stereotype.Service;

import com.Constants.GoldenConstant;
import com.codebay.goldeneye.dtos.EmailFormDto;
import com.codebay.goldeneye.models.EmailForm;


@Service
public class WebServiceImp implements IWebService {
    
    @Override
    public String generateEmail(EmailFormDto emailFormDto) {
        EmailForm emailForm = new EmailForm(emailFormDto);

        // Validate forms calling API REST
        // I'm assuming that in this call we are also checking out that deparments and offices exists in the company
        // Call to ApiRestSimulationController avoided

        // Create new email
        char firstLetter = emailForm.getName().charAt(0);
        String surname_short = emailForm.getSurname().length() > 10 ? emailForm.getSurname().substring(0, 12) : emailForm.getSurname();
        GoldenConstant.Departments deparment = emailForm.getDepartment();
        GoldenConstant.Offices office = emailForm.getOffice();

        String newEmail = firstLetter + surname_short + GoldenConstant.DOT + deparment + GoldenConstant.AT 
            + office + GoldenConstant.DOT + GoldenConstant.GOLDEN_EYE_COM;

        return newEmail.toLowerCase();
    }
}