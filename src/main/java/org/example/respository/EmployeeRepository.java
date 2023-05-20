package org.example.respository;

import org.example.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

  /*  @Query("select * from Employee emp where emp.firstname like %?1")
    List<Employee> findAllEmployeesByName(String firstname);

   */
}
