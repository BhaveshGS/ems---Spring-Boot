package com.ems.ems.mapper;

import com.ems.ems.dto.EmployeeDto;
import com.ems.ems.entity.Employee;

//Converts data from Entity to DTO and vice versa. This helps in keeping the layers decoupled.

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );//maps employee jpa_entity to dto
    }
    public static Employee mapToEmployeeEntity(EmployeeDto employeeDto){
        return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail()
        );//maps employee dto to jpa_entity
    }
}
