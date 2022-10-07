package com.ltd.java.gradesubmission.learningspring;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator<Score, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value > 100 || value < 0) return false; 
        return true;
    }
}
