package com.example.enoca.model.dto;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private int id;
    private String name;
    private Integer parentId;
   // private DepartmentDto parentDepartment;
}
