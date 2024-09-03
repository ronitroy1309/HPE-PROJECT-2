import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class EmployeeController {

    private EmployeeManager employeeManager = new EmployeeManager();

    @GetMapping("/employees")
    public Employees getAllEmployees() {
        return employeeManager.getEmployees();
    }

    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody Employee newEmployee) {
        Employees employees = employeeManager.getEmployees();
        employees.getEmployeeList().add(newEmployee);
        return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
    }
}
