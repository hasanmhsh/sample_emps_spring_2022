package hasan.mohamed.shehata.sampleemps.controllers;

import hasan.mohamed.shehata.sampleemps.models.Employee;
import hasan.mohamed.shehata.sampleemps.models.ErrorDetail;
import hasan.mohamed.shehata.sampleemps.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    http://localhost:2019/employees/employees
    @ApiOperation(value = "returns all Employees",
        response = Employee.class,
        responseContainer = "List")
    @GetMapping(value = "/employees" , produces = {"application/json"})
    public ResponseEntity<?> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    //    http://localhost:2019/employees/employee/16
    @ApiOperation(value = "Retrieve an employee based off of employee id",
            response = Employee.class)
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Employee Found",
            response = Employee.class), @ApiResponse(code = 404,
            message = "Employee Not Found",
            response = ErrorDetail.class)})
    // method header
    //...
    @ApiParam(value = "Employee id",
            required = true,
            example = "4")
    // @PathVariable and following
    @GetMapping(value = "/employee/{id}" , produces = {"application/json"})
    public ResponseEntity<?> getEmployeeById(@PathVariable long id){
        Employee employee = employeeService.getById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

//    http://localhost:2019/employees/employeename/mon
    @GetMapping(value = "/employeename/{part}" , produces = {"application/json"})
    public ResponseEntity<?> getEmployeeByNameContaining(@PathVariable String part){
        List<Employee> employees = employeeService.getByNameLike(part);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

//    http://localhost:2019/employees/employeeemail/com
    @GetMapping(value = "/employeeemail/{part}", produces = {"application/json"})
    public ResponseEntity<?> getEmployeesByEmailContaining(@PathVariable String part){
        List<Employee> employees = employeeService.getEmployeesByEmailContaining(part);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

//    POST http://localhost:2019/employees/employee
    @PostMapping(value = "/employee", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> createNewEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.save(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

//    PUT http://localhost:2019/employees/employee/16
    @PutMapping(value = "/employee/{id}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> replacesCurrentEmployee(@RequestBody Employee employee, @PathVariable long id){
        employee.setEmployeeid(id);
        Employee newEmployee = employeeService.save(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }
//    PATCH http://localhost:2019/employees/employee/16
    @PatchMapping(value = "/employee/{id}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> updateCurrentEmployee(@RequestBody Employee employee, @PathVariable long id){
        Employee newEmployee = employeeService.update(id,employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

//    DELETE http://localhost:2019/employees/employee/16
    @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id){
        employeeService.delete(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }



    
}
