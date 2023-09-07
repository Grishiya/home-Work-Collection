package sky.pro.homeworkcollection.contoller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.service.EmployeeService;
import sky.pro.homeworkcollection.util.FullNameValidator;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        EmployeeController.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") double salary,
                                @RequestParam("department") int department) {
        FullNameValidator.checkName(name, lastName);
        return employeeService.addEmployee(name, lastName, salary, department);
    }

    @GetMapping("/contains")
    public Employee containsEmployee(@RequestParam("firstName") String name,
                                     @RequestParam("lastName") String lastName,
                                     @RequestParam("salary") double salary,
                                     @RequestParam("department") int department) {
        FullNameValidator.checkName(name, lastName);
        return employeeService.containsEmployee(name, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String name,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("salary") double salary,
                                   @RequestParam("department") int department) {
        FullNameValidator.checkName(name, lastName);
        return employeeService.removeEmployee(name, lastName);

    }

    @GetMapping
    public Collection<Employee> allEmployee() {
        return employeeService.allEmployee();
    }
}