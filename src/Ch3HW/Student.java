/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3HW;

/**
 *
 * @author khatib
 */
public class Student {
    private Integer id;
    private String name;
    private String major;
    private Double grade;

    public Student(Integer id, String name, String major, Double grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the grade
     */
    public Double getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
}
