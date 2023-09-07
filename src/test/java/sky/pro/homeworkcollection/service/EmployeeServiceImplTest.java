package sky.pro.homeworkcollection.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.exception.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeServiceImplTest {
    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee("Ivan", "IVANOV", 100500.0, 2);
   /* String firstName = "Ivan";
    String lastName = "Ivanov";
    int department = 2;
    double salary = 23412;*/

    @Test
    void containsEmployee() {
    }

    @Test
    void removeEmployee_employeeIsNotInMap_throwException() {
        final EmployeeNotFoundException exc = assertThrows(
                        EmployeeNotFoundException.class,
                        () -> underTest.removeEmployee("Ivan", "Ivanov"));
        assertEquals("Такого сотрудника нет ", exc.getMessage());
    }

    @Test
    void removeEmployee_employeeIsNotInMap_employeeRemovedAntReturned() {
        underTest.addEmployee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment());

        Employee result;
        result = underTest.removeEmployee(
                employee.getFirstName(),
                employee.getLastName());

        assertEquals(employee, result);
        assertFalse(underTest.allEmployee().contains(employee));
    }

    @Test
    void allEmployee() {
    }
}