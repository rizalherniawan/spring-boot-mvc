package com.ltd.java.gradesubmission.learningspring.service;
import java.util.List;

import com.ltd.java.gradesubmission.learningspring.grade;
import com.ltd.java.gradesubmission.learningspring.repository.GradeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGrade {
    
    @Autowired
    GradeRepository gradeRepository;

    public grade getGrade(int index) {
        return this.gradeRepository.getGrade(index);
    }

    public void addGrade(grade grade) {
        this.gradeRepository.addGrade(grade);
    }

    public List<grade> getListGrades() {
        return this.gradeRepository.getListGrades();
    }

    public void updateGrade(int index ,grade grade) {
        this.gradeRepository.updateGrade(index, grade);
    }

    public grade getGradeByListIndex(String id) {
        int index = this.getGradeIndex(id);
        if(index == -100) return new grade(null, null, 0); 
        return this.getGrade(index);
    }

    public int getGradeIndex(String id) {
        for(int i = 0; i < this.gradeRepository.getListGrades().size(); i++){
            if(this.gradeRepository.getGrade(i).getId().equals(id)){
                return i;
            }
        }
        return -100;
    }

    public void addOrUpdateGrade(String id, grade grade) {
        int index = this.getGradeIndex(id);
        if(index == -100) {
            this.addGrade(grade);;
        } else {
            this.updateGrade(index, grade);
        }
    }

}
