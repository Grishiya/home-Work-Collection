package sky.pro.homeworkcollection.service;

import org.apache.el.lang.FunctionMapperImpl;
import org.springframework.stereotype.Service;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.exception.EmployeeAlreadyAddedException;
import sky.pro.homeworkcollection.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryEmployee(int department) {
        return employeeService.allEmployee().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника в отделе нет " + department));
    }

    @Override
    public Employee findMinSalaryEmployee(int department) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника в отделе нет " + department));
    }

    @Override
    public Collection<Employee> getAllEmployeeDepartment(int department) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllGropingByDepartment() {
        return employeeService.allEmployee().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }
}
