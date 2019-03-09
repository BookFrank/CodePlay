package com.tazine.container.collection.set.cases.stud;

/**
 * Student
 *
 * @author frank
 * @date 2018/1/27
 */
public class Student {

    private int sno;

    private String name;

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object obj) {
//        Student stu = (Student) obj;
//        if (stu.getSno() == this.sno){
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public int hashCode() {
//        return this.sno;
//    }
}
