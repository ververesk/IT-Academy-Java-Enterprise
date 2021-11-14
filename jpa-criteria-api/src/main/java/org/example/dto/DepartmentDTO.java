package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Employee;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class DepartmentDTO {
    private String departmentName;
    private int maxSalary;
    private int minSalary;
    private List<Employee> emps=new ArrayList<>();
}
