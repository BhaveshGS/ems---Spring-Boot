package com.ems.ems.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.ems.dto.EmployeeDto;
import com.ems.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController //this annotation enables this class to handle http requests
@RequestMapping(value = "/api/employees")
//to define base url for all rest apis

//Receives HTTP requests, validates them, and sends them to the appropriate Service method.
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping //maps incoming post request to this method
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) //extracts json in incoming post request and converts it into dto java object
    {
        EmployeeDto savedEmployee = employeeService.createEmployee((employeeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long Id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(Id);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    //service return a list of dtos so response entity should be declared as list
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> allEmployeesList = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployeesList);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long Id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.updateEmployee(Id, employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long Id){
        employeeService.deleteEmployee(Id);
        return ResponseEntity.ok("Employee with id : "+Id+" is deleted successfully");
    }
}
