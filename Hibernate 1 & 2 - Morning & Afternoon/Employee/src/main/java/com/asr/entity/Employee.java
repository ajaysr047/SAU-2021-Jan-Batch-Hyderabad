package com.asr.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "employeeId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Address> addresses;

    @ManyToMany
    @JoinTable(name = "Employee_Course", joinColumns = {@JoinColumn(referencedColumnName = "empId")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "courseId")})
    private Set<Course> courses;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
