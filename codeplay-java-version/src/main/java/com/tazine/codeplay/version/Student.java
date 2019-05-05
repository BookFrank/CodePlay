package com.tazine.codeplay.version;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Student
 *
 * @author frank
 * @date 2019-04-18
 */
@Data
@AllArgsConstructor
public class Student {

    private String name;

    private int score;

    private int age;

    //private String school;

    private String province;

    private String nation;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
