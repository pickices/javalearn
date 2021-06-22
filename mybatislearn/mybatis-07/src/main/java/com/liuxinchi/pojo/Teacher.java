package com.liuxinchi.pojo;

import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + ", students=" + students + "]";
    }

}
