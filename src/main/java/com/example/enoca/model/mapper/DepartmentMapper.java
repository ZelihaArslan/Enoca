package com.example.enoca.model.mapper;

import com.example.enoca.model.dto.DepartmentDto;
import com.example.enoca.model.dto.EmployeeDto;
import com.example.enoca.model.entity.Department;
import com.example.enoca.model.entity.Employee;
import com.example.enoca.model.request.CreateUpdateDepartmentRequest;
import com.example.enoca.model.request.CreateUpdateEmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentMapper DEPARTMENT_MAPPER= Mappers.getMapper(DepartmentMapper.class);//sistemdeki employee mapperı yakala erişilebilir hale getir

     DepartmentDto toDepartmentDto(Department department);
     List<DepartmentDto> toDepartmentDtoList(List<Department> departments);

      Department createDepartment(CreateUpdateDepartmentRequest request);
//
//    void updateEmployee(@MappingTarget Employee employee, CreateUpdateEmployeeRequest request);
}
