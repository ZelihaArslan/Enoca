package com.example.enoca.model.mapper;

import com.example.enoca.model.dto.DepartmentDto;
import com.example.enoca.model.entity.Department;
import com.example.enoca.model.request.CreateUpdateDepartmentRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-17T17:00:09+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_302 (Azul Systems, Inc.)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto toDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        if ( department.getId() != null ) {
            departmentDto.setId( department.getId() );
        }
        departmentDto.setName( department.getName() );
        departmentDto.setParentId( department.getParentId() );

        return departmentDto;
    }

    @Override
    public List<DepartmentDto> toDepartmentDtoList(List<Department> departments) {
        if ( departments == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( departments.size() );
        for ( Department department : departments ) {
            list.add( toDepartmentDto( department ) );
        }

        return list;
    }

    @Override
    public Department createDepartment(CreateUpdateDepartmentRequest request) {
        if ( request == null ) {
            return null;
        }

        Department department = new Department();

        department.setName( request.getName() );
        department.setParentId( request.getParentId() );

        return department;
    }
}
