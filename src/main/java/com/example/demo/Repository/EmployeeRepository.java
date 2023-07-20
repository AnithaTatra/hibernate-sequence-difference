package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
