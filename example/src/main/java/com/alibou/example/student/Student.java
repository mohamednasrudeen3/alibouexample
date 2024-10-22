package com.alibou.example.student;


import com.alibou.example.school.School;
import com.alibou.example.studentprofile.StudentProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="T_STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="c_fname")
    private String firstname;

    @Column
    private String lastname;

    @Column(unique = true)
    private String email;


//upadatable false used for example creation date
    @Column(updatable = false)
    private String some_column;


    private int age;


    public Student() {
    }



    public Student(String firstname, int age, String lastname, String email) {
        this.firstname = firstname;
        this.age = age;
        this.lastname = lastname;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


//relationships
    @OneToOne(
            mappedBy="student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }




    @ManyToOne
    @JoinColumn(name="school_id")
    @JsonBackReference
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }





}
