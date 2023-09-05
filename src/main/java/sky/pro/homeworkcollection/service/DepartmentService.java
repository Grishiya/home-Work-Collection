package sky.pro.homeworkcollection.service;

import sky.pro.homeworkcollection.dto.Employee;

public interface DepartmentService {
    Employee findMaxSalaryEmployee(int department);

    Employee findMinSalaryEmployee(int department);

    Employee getAllEmployeeDepartment(int department);
}
