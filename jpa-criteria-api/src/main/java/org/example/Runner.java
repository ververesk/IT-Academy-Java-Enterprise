package org.example;

import org.example.dto.DepartmentDTO;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.entity.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//JPQL!!!!!!!!!!!!!!!!
        //from
//        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //select simple
//        TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //max salary
//        Query query = em.createQuery("Select MAX(e.salary) FROM Employee e", Integer.class);
//        int maxSalary = (int) query.getSingleResult();
//        System.out.println(maxSalary);

        //only names
//        Query query = em.createQuery("Select e.name FROM Employee e", String.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //Order BY with NamedQuery
//        TypedQuery<Employee> query = em.createNamedQuery("orderByName", Employee.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //select several fields to DTO whit filter and NamedQuery
//        TypedQuery<EmployeeDTO> query = em.createNamedQuery("filterBySalary", EmployeeDTO.class);
//        query.setParameter("salary", 1000);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //update Employee
//        Query query = em.createQuery("UPDATE Employee e SET e.salary = 1150 WHERE e.id = 7");
//        System.out.println(query.executeUpdate());

        //select left outer implicit join
//        TypedQuery<Department> query = em.createQuery("select e.department from Employee e", Department.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //select left outer explicit join with dto
//        TypedQuery<EmployeeDTO> query = em.createQuery(
//                "select new org.example.dto.EmployeeDTO(e.name, e.surname, e.salary, d.departmentName) from Employee e, Department d where e.department = d", EmployeeDTO.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

        //Criteria API!!!!!!!!!!!!!
        //min salary among min salaries
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
//        Root<Department> root = query.from(Department.class);
//        query.select(builder.min(root.get("minSalary")));
//        Integer min = em.createQuery(query).getSingleResult();
//        System.out.println(min);

        //max salary among min salaries
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
//        Root<Department> root = query.from(Department.class);
//        query.select(builder.max(root.get("minSalary")));
//        Integer max = em.createQuery(query).getSingleResult();
//        System.out.println(max);

        //sum min salaries among min salaries
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
//        Root<Department> root = query.from(Department.class);
//        query.select(builder.sum(root.get("minSalary")));
//        Integer sum = em.createQuery(query).getSingleResult();
//        System.out.println(sum);

        // using constructor
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
//        Root <Department>department = criteriaQuery.from(Department.class);
//        criteriaQuery.select(criteriaBuilder.construct(Department.class, department.get("id"), department.get("departmentName"), department.get("maxSalary"), department.get("minSalary")));
//        Query query = em.createQuery(criteriaQuery);
//        List<Department> result = query.getResultList();
//        for (Department dep : result) {
//            System.out.println(dep);
//        }

        //Order by Surname
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employee = criteriaQuery.from(Employee.class);
        criteriaQuery.orderBy(criteriaBuilder.asc(employee.get("surname")));
        em.createQuery(criteriaQuery).getResultList().forEach(Runner::printWithPrefix);


        tx.commit();
        em.close();
    }

    private static void printWithPrefix(Object obj) {
        System.out.println("!!!" + obj);
    }
}
