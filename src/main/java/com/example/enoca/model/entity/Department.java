package com.example.enoca.model.entity;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="departments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name="parent_id")
    private Integer parentId;

    //1 departmanın altında bir çok çalısan olabilir.
    @ManyToOne(fetch = FetchType.LAZY) //departmanı çektiğimde parenta erişmek istediğimde git sorguya at getir.
    @JoinColumn(name = "parent_id",nullable = false,insertable = false,updatable = false)
    private Department parentDepartment;

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
   private List<Employee> employeeList;



}
