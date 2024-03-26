package com.tpe.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please enter valid first name") //@NotBlank = not empty(""), not null, not blank(" ")
    private String firstName;
    @NotEmpty(message = "Please enter valid last name") //@NotEmpty = not empty(""), not null
    private String lastName;
    @NotNull(message = "Please enter grade") //@NotNull = not null
    private Integer grade;
    @NotNull
    private LocalDateTime createDate = LocalDateTime.now();

    //getter and setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

//    public void setCreatedDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }

    //toString


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", createdDate=" + createDate +
                '}';
    }
}
