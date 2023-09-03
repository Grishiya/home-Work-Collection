package sky.pro.homeworkcollection.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.exception.EmployeeStorageIsFullException;
import sky.pro.homeworkcollection.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        EmployeeController.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(name, lastName);
        employeeService.addEmployee(name, lastName);

        return employee;
     }

    @GetMapping("/contains")
    public Employee containsEmployee(@RequestParam("firstName") String name,
                                     @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(name, lastName);
        employeeService.containsEmployee(name, lastName);
        return employee;
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String name,
                                   @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(name, lastName);
        employeeService.removeEmployee(name, lastName);
        return employee;
    }
}