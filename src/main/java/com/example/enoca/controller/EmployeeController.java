package com.example.enoca.controller;


import com.example.enoca.model.dto.EmployeeDto;
import com.example.enoca.model.request.CreateUpdateEmployeeRequest;
import com.example.enoca.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody CreateUpdateEmployeeRequest request) {
        return service.createEmployee(request);
    }

    @GetMapping("{id}")
    public EmployeeDto getEmployee(@PathVariable int id){
        return service.getEmployee(id);
    }
    @PutMapping("{id}")
    public EmployeeDto updateEmployee(@PathVariable int id, @RequestBody CreateUpdateEmployeeRequest request) {
        return service.updateEmployee(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable int id){
         service.deleteEmployee(id);
    }

    @GetMapping
    //kullanıcı birşeyler kısıtlamak isterse; ben name e göre kısıtlama yaptım.
    // Kullanıcı isme göre arama yapmak isterse
    public List<EmployeeDto> getEmployees(){
        return service.getEmployees();
    }
}
