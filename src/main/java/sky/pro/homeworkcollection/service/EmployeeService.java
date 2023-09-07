package sky.pro.homeworkcollection.service;

import sky.pro.homeworkcollection.dto.Employee;

import java.util.Collection;

public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName, double salary, int department);

    Employee containsEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

 Collection<Employee> allEmployee();
}
