package com.crud.rs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.rs.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
