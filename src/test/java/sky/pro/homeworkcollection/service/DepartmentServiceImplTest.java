package sky.pro.homeworkcollection.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    EmployeeServiceImpl employeeService;
    @InjectMocks
    DepartmentServiceImpl underTest;

    Employee ivan = new Employee(
            "Ivan",
            "Ivanov",
            10500,
            1);
    Employee max = new Employee(
            "Max",
            "Maximov",
            100600,
            1);
    Employee grisha = new Employee("Grisha",
            "Volkiov",
            100700,
            2);
    Collection<Employee> employees;

    @BeforeEach
    void beforeEach() {
        employees = List.of(ivan, max, grisha);

    }

    @Test
    void findMaxSalaryEmployee_employeeFind_returnEmployeeWithMaxSalary() {
        when(employeeService.allEmployee()).thenReturn(employees);
        final Employee result = underTest.findMaxSalaryEmployee(1);
        assertEquals(max, result);
    }
    @Test
    void findMaxSalaryEmployee_employeeNotFind_thrownEmployeeNotFoundException() {
        int department = 1;
        when(employeeService.allEmployee()).thenReturn(Collections.emptyList());
   EmployeeNotFoundException exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> underTest.findMaxSalaryEmployee(department));
        assertEquals("Такого сотрудника в отделе нет " +department,
                exception.getMessage());
    }

    @Test
    void findMinSalaryEmployee_employeeFind_returnEmployeeWithMinSalary() {
        when(employeeService.allEmployee()).thenReturn(employees);
        final Employee result = underTest.findMinSalaryEmployee(1);
        assertEquals(max, result);
    }
    @Test
    void findMinSalaryEmployee_employeeNotFind_thrownEmployeeNotFoundException() {
        int department = 1;
        when(employeeService.allEmployee()).thenReturn(Collections.emptyList());
        EmployeeNotFoundException exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> underTest.findMinSalaryEmployee(department));
        assertEquals("Такого сотрудника в отделе нет " + department,
                exception.getMessage());
    }
    @Test
    void getAllEmployeeDepartment() {
    }

    @Test
    void getAllGropingByDepartment() {
    }
}