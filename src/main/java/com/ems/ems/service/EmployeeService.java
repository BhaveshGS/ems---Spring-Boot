package com.ems.ems.service;
import com.ems.ems.dto.EmployeeDto;
import java.util.List;

//Processes the business logic. If data needs to be fetched or stored, it uses the Repository.
public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
    
    List<EmployeeDto> getAllEmployees();
    
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    
    void deleteEmployee(Long id);
}
