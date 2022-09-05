package com.codebay.goldeneye;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Constants.GoldenConstant.Departments;
import com.Constants.GoldenConstant.Offices;
import com.codebay.goldeneye.dtos.EmailFormDto;
import com.codebay.goldeneye.services.WebServiceImp;

@Controller
public class WebController {  

    @Autowired
    private WebServiceImp webService;

    @GetMapping("/")
    public String index(Model model) {
        ArrayList<Departments> allDepartments = new ArrayList<>();
        ArrayList<Offices> allOffices = new ArrayList<>();

        allDepartments.add(Departments.DESIGN);
        allDepartments.add(Departments.BUSINESS);
        allDepartments.add(Departments.ADVERTISING);
        allDepartments.add(Departments.RESEARCH_AND_DEV);

        allOffices.add(Offices.SPAIN);
        allOffices.add(Offices.MILAN);
        allOffices.add(Offices.NEW_YORK);

        model.addAttribute("allDepartments", allDepartments);
        model.addAttribute("allOffices", allOffices);
        model.addAttribute("emailForm", new EmailFormDto());
        return "index";    }


    /**
     * Given personal data from worker (name, surname, department, office) generate a valid new email
     * @param emailFormDto
     * @return new email for worker
     */
    @PostMapping("/email-gen")
    public String emailGen(@Validated @ModelAttribute(value="emailForm") EmailFormDto emailFormDto, Model model) {
        try { 
            String newEmail = webService.generateEmail(emailFormDto);
            model.addAttribute("newEmail", newEmail);
            return "emailView";
            // return ResponseEntity.ok(newEmail);
        } catch (Error err) {
            return err.getMessage();
        }
        
    }

}