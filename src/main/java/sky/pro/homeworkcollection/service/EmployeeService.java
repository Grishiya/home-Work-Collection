package sky.pro.homeworkcollection.service;

import sky.pro.homeworkcollection.dto.Employee;

public interface EmployeeService {


    void addEmployee(String firstName, String lastName);

    void containsEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);
}
