package sky.pro.homeworkcollection.service;

import org.springframework.stereotype.Service;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.exception.EmployeeAlreadyAddedException;
import sky.pro.homeworkcollection.exception.EmployeeNotFoundException;
import sky.pro.homeworkcollection.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employeeMap;


    private static final int EMPLOYEE_MAX_SIZE = 3;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int department) {
        String fullName = firstName + lastName;
        if (employeeMap.keySet().size() == EMPLOYEE_MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Закрыто");
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException("ТЫ уже работаешь");
        }
        employeeMap.put(fullName, employee);
        return employee;
    }


    @Override
    public Employee containsEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.get(firstName + lastName);
        if (!employeeMap.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.remove(firstName + lastName);

        if (!employeeMap.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }

        return employee;
    }

    @Override
    public Collection<Employee> allEmployee() {
        return employeeMap.values();
    }
}
