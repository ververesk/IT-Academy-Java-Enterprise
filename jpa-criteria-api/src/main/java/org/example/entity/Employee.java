package org.example.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(exclude = "department")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "filterBySalary", query = "select new org.example.dto.EmployeeDTO (e.name, e.surname, e.salary) from Employee e where e.salary < :salary"),
        @NamedQuery(name = "orderByName", query = "SELECT e FROM Employee e ORDER BY e.name ASC")
})

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private int salary;
   // @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private Department department;


    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

}

