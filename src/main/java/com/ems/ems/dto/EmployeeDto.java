package com.ems.ems.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Used to transfer data between layers, particularly from Controller to Service and vice versa
//Employe dto class to transfer data b/w client and server
//response class for rest apis
//whenever restful services are built, we've to convert dto to jpa_entity and vice versa

public class EmployeeDto {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
}
