package sky.pro.homeworkcollection.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.exception.EmployeeAlreadyAddedException;
import sky.pro.homeworkcollection.exception.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeServiceImplTest {
    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee("Ivan",
            "IVANOV",
            100500.0,
            2);

    @Test
    void addEmployee__checkAdditionAnEmployee() {
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
    void containsEmployee() {
        underTest.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());
        Employee result = underTest.containsEmployee(
                employee.getFirstName(),
                employee.getLastName()
        );
        assertEquals(employee,result);
    }

    @Test
    void removeEmployee_employeeIsNotInMap_throwException() {
        final EmployeeNotFoundException exc = assertThrows(
                EmployeeNotFoundException.class,
                () -> underTest.removeEmployee("Ivan", "Ivanov"));
        assertEquals("Такого сотрудника нет", exc.getMessage());
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
    void allEmployee() {
    }
}