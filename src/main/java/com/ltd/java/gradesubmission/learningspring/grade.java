package com.ltd.java.gradesubmission.learningspring;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class grade {

    @NotBlank(message = "Name cannot be blank") 
    private String name;

    @NotBlank(message = "Subject cannot be blank")
    private String subject;

    @Score(message = "Please input valid integer")
    private int score;
    private String id;


    public grade(String name, String subject, int score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", subject='" + getSubject() + "'" +
            ", score='" + getScore() + "'" +
            "}";
    }
}
