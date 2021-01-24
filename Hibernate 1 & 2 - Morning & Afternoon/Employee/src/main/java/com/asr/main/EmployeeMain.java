package com.asr.main;

import com.asr.entity.Address;
import com.asr.entity.Course;
import com.asr.entity.Employee;
import com.asr.entity.EmployeeDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class EmployeeMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class)
                .addAnnotatedClass(EmployeeDetails.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Employee employee1 = new Employee("Ajay", "S");

        Employee employee2 = new Employee("Kure", "Ryan");

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmployee(employee1);
        employeeDetails.setEmail("demo@gmail.com");
        employeeDetails.setPhone("9895053047");

        EmployeeDetails employeeDetails2 = new EmployeeDetails();
        employeeDetails2.setEmployee(employee2);
        employeeDetails2.setEmail("demo2@gmail.com");
        employeeDetails2.setPhone("9895053047");

        Address empAddress = new Address();
        empAddress.setCity("Kumily");
        empAddress.setStreetName("Rosapookandam");
        empAddress.setPinCode(685509);
        empAddress.setEmployeeId(1);

        Address empAddress2 = new Address();
        empAddress2.setCity("1st Mile");
        empAddress2.setStreetName("Church street");
        empAddress2.setPinCode(685509);
        empAddress2.setEmployeeId(1);

        Address empAddress3 = new Address();
        empAddress3.setCity("2nd Mile");
        empAddress3.setStreetName("Rosapookandam");
        empAddress3.setPinCode(685509);
        empAddress3.setEmployeeId(2);

        Course course1 = new Course("Demo 1");

        Course course2 = new Course("Demo 2");

        Course course3 = new Course("Demo 3");

        Set<Course> courseSet = new HashSet<>();
        courseSet.add(course1);
        courseSet.add(course2);

        employee1.setCourses(courseSet);

        Set<Course> courseSet2 = new HashSet<>();
        courseSet2.add(course1);
        courseSet2.add(course2);
        courseSet2.add(course3);

        employee2.setCourses(courseSet2);

        try{
            session.beginTransaction();
            session.save(course1);
            session.save(course2);
            session.save(course3);
            session.save(employee1);
            session.save(employee2);
            session.save(empAddress);
            session.save(empAddress2);
            session.save(empAddress3);
            session.save(employeeDetails);
            session.save(employeeDetails2);
            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }

}
