package com.example.enoca.model.mapper;

import com.example.enoca.model.dto.EmployeeDto;
import com.example.enoca.model.entity.Employee;
import com.example.enoca.model.request.CreateUpdateEmployeeRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-17T17:00:10+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_302 (Azul Systems, Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto toEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        if ( employee.getId() != null ) {
            employeeDto.setId( employee.getId() );
        }
        employeeDto.setName( employee.getName() );
        employeeDto.setDescription( employee.getDescription() );
        if ( employee.getSalary() != null ) {
            employeeDto.setSalary( employee.getSalary() );
        }
        employeeDto.setDepartmentId( employee.getDepartmentId() );

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> toEmployeeDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( toEmployeeDto( employee ) );
        }

        return list;
    }

    @Override
    public Employee createEmployee(CreateUpdateEmployeeRequest request) {
        if ( request == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setName( request.getName() );
        employee.setDescription( request.getDescription() );
        employee.setSalary( request.getSalary() );
        employee.setDepartmentId( request.getDepartmentId() );

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee, CreateUpdateEmployeeRequest request) {
        if ( request == null ) {
            return;
        }

        employee.setName( request.getName() );
        employee.setDescription( request.getDescription() );
        employee.setSalary( request.getSalary() );
        employee.setDepartmentId( request.getDepartmentId() );
    }
}
