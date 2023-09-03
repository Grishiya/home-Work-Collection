package sky.pro.homeworkcollection.service;

import org.springframework.stereotype.Service;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.exception.EmployeeAlreadyAddedException;
import sky.pro.homeworkcollection.exception.EmployeeNotFoundException;
import sky.pro.homeworkcollection.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;
    private static final int EMPLOYEE_MAX_SIZE = 4;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();

    }

    @Override
    public void addEmployee(String firstName, String lastName) {
        if (employees.size() == EMPLOYEE_MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Закрыто");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("ТЫ уже работаешь");
        }
        employees.add(employee);
    }


    @Override
    public void containsEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
        boolean contains = employees.contains(employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.remove(employee)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
        employees.remove(employee);
    }
}
