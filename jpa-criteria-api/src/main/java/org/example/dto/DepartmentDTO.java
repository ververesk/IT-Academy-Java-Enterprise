package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Employee;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDTO {
    private int id;
    private String departmentName;
    private int maxSalary;
    private int minSalary;
  //  private List<Employee> emps=new ArrayList<>();
}
