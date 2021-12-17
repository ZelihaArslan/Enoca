package com.example.enoca.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

//db ile haberleştiğim yer(entity)
@Entity
@Table(name="employees")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max=100)
    @Column(unique = true,length = 100,nullable = false) //aynı isimde employee olmasını engellemek için
    private String name;

    @NotBlank
    @Size(max=150)
    @Column(length = 150, nullable = false)
    private String description;

    @Min(1)
    @Column(nullable = false)
    private Double salary;

    @Column(name="category_id")
    private Integer departmentId;

    @ManyToOne(fetch = FetchType.LAZY) //departmanı çektiğimde parenta erişmek istediğimde git sorguya at getir.
    @JoinColumn(name = "category_id",nullable = false,insertable = false,updatable = false)
    private Department department;

}
