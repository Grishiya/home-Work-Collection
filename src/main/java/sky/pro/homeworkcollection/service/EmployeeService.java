package sky.pro.homeworkcollection.service;

import sky.pro.homeworkcollection.dto.Employee;

import java.util.List;

public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName);

    Employee containsEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    List<Employee> allEmploeyy();
}
