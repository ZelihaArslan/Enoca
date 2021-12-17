package com.example.enoca.service;


import com.example.enoca.model.dto.EmployeeDto;
import com.example.enoca.model.entity.Employee;
import com.example.enoca.model.request.CreateUpdateEmployeeRequest;
import com.example.enoca.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.enoca.model.mapper.EmployeeMapper.EMPLOYEE_MAPPER;

@Service
@RequiredArgsConstructor //repository alabilmek için
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeDto createEmployee(CreateUpdateEmployeeRequest request) {
       Employee employee= EMPLOYEE_MAPPER.createEmployee(request);

        Employee savedEmployee= repository.save(employee);
        return EMPLOYEE_MAPPER.toEmployeeDto(savedEmployee);
    }

    public EmployeeDto getEmployee(int id) {
        Employee employee=getEmployeeEntity(id);
        return EMPLOYEE_MAPPER.toEmployeeDto(employee); //dto dönebilmek için convert metodu yazdık
    }

    private Employee getEmployeeEntity(int id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    public EmployeeDto updateEmployee(int id, CreateUpdateEmployeeRequest request) {
        Employee employee=getEmployeeEntity(id);
       EMPLOYEE_MAPPER.updateEmployee(employee, request);

        Employee updatedEmployee=repository.save(employee);
       return EMPLOYEE_MAPPER.toEmployeeDto(updatedEmployee);
    }

    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }

    public List<EmployeeDto> getEmployees() {
        return EMPLOYEE_MAPPER.toEmployeeDtoList(repository.findAll());
    }
}
