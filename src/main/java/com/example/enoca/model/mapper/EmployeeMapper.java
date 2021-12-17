package com.example.enoca.model.mapper;

import com.example.enoca.model.dto.EmployeeDto;
import com.example.enoca.model.entity.Employee;
import com.example.enoca.model.request.CreateUpdateEmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

//
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER= Mappers.getMapper(EmployeeMapper.class);//sistemdeki employee mapperı yakala erişilebilir hale getir

    EmployeeDto toEmployeeDto(Employee employee);
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employees);
    Employee createEmployee(CreateUpdateEmployeeRequest request);

    void updateEmployee(@MappingTarget Employee employee, CreateUpdateEmployeeRequest request);
}
