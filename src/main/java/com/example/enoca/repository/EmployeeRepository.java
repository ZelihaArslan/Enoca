package com.example.enoca.repository;

import com.example.enoca.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
   // List<Employee> findAllByNameContains(String name);

   // List<Employee> findAllByContainsOrDescriptionContains(String name,String description);

}
