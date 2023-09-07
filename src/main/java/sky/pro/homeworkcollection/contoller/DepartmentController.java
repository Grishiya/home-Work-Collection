package sky.pro.homeworkcollection.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.homeworkcollection.dto.Employee;
import sky.pro.homeworkcollection.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    final private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/maxSalary")
    public Employee getEmployeeMaxSalaryByDepartment(@RequestParam("department") int department) {
        return departmentService.findMaxSalaryEmployee(department);
    }

    @GetMapping("/misSalary")
    public Employee getEmployeeMinSalaryByDepartment(@RequestParam("department") int department) {
        return departmentService.findMinSalaryEmployee(department);
    }


    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllDepartmentByGrouping() {
        return departmentService.getAllGropingByDepartment();
    }

    @GetMapping(path = "/all", params = {"department"})
    public Collection<Employee> getAllEmployeesDepartment(@RequestParam int department) {
        return departmentService.getAllEmployeeDepartment(department);
    }
}

