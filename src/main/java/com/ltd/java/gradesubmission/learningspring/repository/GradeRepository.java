package com.ltd.java.gradesubmission.learningspring.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import com.ltd.java.gradesubmission.learningspring.grade;

@Repository
public class GradeRepository {

    private List<grade> allStudentGrades = new ArrayList<>();

    public grade getGrade(int index) {
        return this.allStudentGrades.get(index);
    }

    public void addGrade(grade grade) {
        this.allStudentGrades.add(grade);
    }

    public List<grade> getListGrades() {
        return this.allStudentGrades;
    }

    public void updateGrade(int index ,grade grade) {
        this.allStudentGrades.set(index, grade);
    }
}
