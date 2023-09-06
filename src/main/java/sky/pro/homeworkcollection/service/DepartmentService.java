package sky.pro.homeworkcollection.service;

import sky.pro.homeworkcollection.dto.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findMaxSalaryEmployee(int department);

    Employee findMinSalaryEmployee(int department);

    Collection<Employee> getAllEmployeeDepartment(int department);

    Map<Integer, List<Employee>> getAllGropingByDepartment();
}
