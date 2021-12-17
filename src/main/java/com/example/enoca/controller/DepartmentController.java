package com.example.enoca.controller;

import com.example.enoca.model.dto.DepartmentDto;
import com.example.enoca.model.dto.EmployeeDto;
import com.example.enoca.model.request.CreateUpdateDepartmentRequest;
import com.example.enoca.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService service;

    @PostMapping
    public DepartmentDto createDepartment(@RequestBody CreateUpdateDepartmentRequest request){
        return service.createDepartment(request);
    }

    @GetMapping
    public List<DepartmentDto> getDepartments(){
        return service.getDepartments();
    }
    @GetMapping("{id}/parent")
    public DepartmentDto getParentDepartment(@PathVariable int id){
        return service.getParentDepartment(id);

    }

    @GetMapping("{id}/employees")
    public List<EmployeeDto> getSubDepartment(@PathVariable int id){
        return service.getDepartmentProducts(id);
    }

}
