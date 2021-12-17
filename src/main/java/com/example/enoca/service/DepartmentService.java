package com.example.enoca.service;

import com.example.enoca.model.dto.DepartmentDto;
import com.example.enoca.model.dto.EmployeeDto;
import com.example.enoca.model.entity.Department;
import com.example.enoca.model.request.CreateUpdateDepartmentRequest;
import com.example.enoca.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.enoca.model.mapper.DepartmentMapper.DEPARTMENT_MAPPER;
import static com.example.enoca.model.mapper.EmployeeMapper.EMPLOYEE_MAPPER;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentDto createDepartment(CreateUpdateDepartmentRequest request) {
      Department department=DEPARTMENT_MAPPER.createDepartment(request);
      Department createdDepartment = repository.save(department);
      return DEPARTMENT_MAPPER.toDepartmentDto(createdDepartment);
    }

    public List<DepartmentDto> getDepartments() {
       return DEPARTMENT_MAPPER.toDepartmentDtoList(repository.findAll());
    }

    public DepartmentDto getParentDepartment(int id) {
        Department department=repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        return DEPARTMENT_MAPPER.toDepartmentDto(department.getParentDepartment());
    }

    public List<EmployeeDto> getDepartmentProducts(int id) {
        Department department=repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        return EMPLOYEE_MAPPER.toEmployeeDtoList(department.getEmployeeList());
    }
}
