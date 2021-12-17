package com.example.enoca.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//kullanıcı ile haberleştiğim data objem
public class EmployeeDto {
    private int id;
    private String name;
    private String description;
    private double salary;
    //private Date creationDate;
    private Integer departmentId;

}
