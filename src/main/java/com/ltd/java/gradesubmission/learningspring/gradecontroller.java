package com.ltd.java.gradesubmission.learningspring;


import javax.validation.Valid;


import com.ltd.java.gradesubmission.learningspring.service.ServiceGrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class gradecontroller {

    @Autowired
    ServiceGrade serviceGrade;

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", this.serviceGrade.getListGrades());
        return "grades";
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", this.serviceGrade.getGradeByListIndex(id));
        return "form";
    }


    @PostMapping("/submit")
    public String submitForm(@Valid grade grade, BindingResult result, String id) {
        if(result.hasErrors()) {
            if(id.length() > 0) return "redirect:/?id=" + id; 
            return "redirect:/"; 
        }
        this.serviceGrade.addOrUpdateGrade(id, grade);
        return "redirect:/grades";
    }
}

