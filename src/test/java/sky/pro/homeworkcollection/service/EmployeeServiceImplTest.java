package sky.pro.homeworkcollection.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.exception.EmployeeAlreadyAddedException;
import sky.pro.homeworkcollection.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeServiceImplTest {
    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee("Ivan",
            "IVANOV",
            100500.0,
            2);
    Collection<Employee> allEmployee = new ArrayList<>(List.of(employee));

    @Test
    void addEmployee_checkAdditionAnEmployee_addEmployeeReturned() {
        Employee result = underTest.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());
        assertEquals(employee, result);
    }

    @Test
    void addEmployee_employeeAlreadyInMap_throwException() {
        underTest.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());
        final EmployeeAlreadyAddedException exception =
                assertThrows(
                        EmployeeAlreadyAddedException.class,
                        () -> underTest.addEmployee(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary(),
                                employee.getDepartment())
                );
        assertEquals("ТЫ уже работаешь", exception.getMessage());
    }

    @Test
    void containsEmployee_searchForAnEmployeeInMap_employeeContainsReturned() {
        underTest.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());
        Employee result = underTest.containsEmployee(
                employee.getFirstName(),
                employee.getLastName()
        );
        assertEquals(employee, result);
    }

    @Test
    void containsEmployee_employeeIsNotInMap_throwException() {
        final EmployeeNotFoundException exception =
                assertThrows(
                        EmployeeNotFoundException.class,
                        () -> underTest.containsEmployee(
                                employee.getFirstName(),
                                employee.getLastName()));
        assertEquals("Такого сотрудника нет", exception.getMessage());
    }

    @Test
    void removeEmployee_employeeIsNotInMap_throwException() {
        final EmployeeNotFoundException exception =
                assertThrows(
                        EmployeeNotFoundException.class,
                        () -> underTest.removeEmployee(
                                employee.getFirstName(),
                                employee.getLastName()));
        assertEquals("Такого сотрудника нет", exception.getMessage());
    }

    @Test
    void removeEmployee_employeeIsNotInMap_employeeRemovedAntReturned() {
        underTest.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());

        Employee result = underTest.removeEmployee(
                employee.getFirstName(),
                employee.getLastName());

        assertEquals(employee, result);
        assertFalse(underTest.allEmployee().contains(employee));
    }

    @Test
    void allEmployee_allEmployeeCheckInCollection_allEmployeeReturned() {
        underTest.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());
       Collection <Employee> result = underTest.allEmployee();
       assertEquals(List.of(employee),result);
        //WHY!!!!
    }
}