package org.example;

import org.example.dto.DepartmentDTO;
import org.example.dto.EmployeeDTO;
import org.example.entity.Employee;
import org.example.entity.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //from
//        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //max salary
//        Query query = em.createQuery("Select MAX(e.salary) FROM Employee e", Integer.class);
//        int maxSalary = (int) query.getSingleResult();
//        System.out.println(maxSalary);

        //only names
//        Query query = em.createQuery("Select e.name FROM Employee e", String.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //select simple
//        TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //Order BY
//        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e ORDER BY e.name ASC", Employee.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //select several fields to DTO whit filter and NamedQuery
//        TypedQuery<EmployeeDTO> query = em.createNamedQuery("filterBySalary", EmployeeDTO.class);
//        query.setParameter("salary", 1000);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //update Employee
//        Query query = em.createQuery("UPDATE Employee e SET e.salary = 1150 WHERE e.id = 7");
//        System.out.println(query.executeUpdate());

//        TypedQuery<EmployeeDTO> query = em.createQuery(
//                "select new org.example.dto.EmployeeDTO(e.name, e.surname, e.salary, d.departmentName) from Employee e, Department d", EmployeeDTO.class);
//        query.getResultList().forEach(Runner::printWithPrefix);


        tx.commit();
        em.close();
    }

    private static void printWithPrefix(Object obj) {
        System.out.println("!!!" + obj);
    }
}
