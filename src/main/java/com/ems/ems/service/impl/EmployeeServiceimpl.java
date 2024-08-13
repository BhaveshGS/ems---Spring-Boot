package com.ems.ems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.ems.dto.EmployeeDto;
import com.ems.ems.entity.Employee;
import com.ems.ems.exception.ResourceNotFoundException;
import com.ems.ems.mapper.EmployeeMapper;
import com.ems.ems.repository.EmployeeRepository;
import com.ems.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

//implements employee service interface
@Service
@AllArgsConstructor //dont have to manually create constructor for EmployeeRepositoy
public class EmployeeServiceimpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployeeEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee); //save method returns saved employee onject which is stored in savedEmployee object
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long Id) {
        Employee savedEmployee = employeeRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Id : " +Id+ " is not found")); 
        //passes this string to the ResourceNotFoundException class
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> listOfEntities = employeeRepository.findAll();
        return listOfEntities.stream().map((singleEntity) -> EmployeeMapper.mapToEmployeeDto(singleEntity)).toList();
        //findAll returns the list of all entities(eg. id:1,2,3,4) which is stored in listOfEntities.It cannot be converted to list of dtos directly
        //it is mapped to single enttiy which is converted to dto, then all the dtos are collected in a list by toList() method
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id : " +id+ " is not found"));
        
        employee.setFirstName(employeeDto.getFirstName());//getting new data from employeeDto while old data to be updated is in employee
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id : " +id+ " is not found"));

        employeeRepository.deleteById(id);
    }    
}
