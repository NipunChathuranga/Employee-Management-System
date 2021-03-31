package com.dev.kynet.demospringbootbackend.repository;
//Spring @Repository annotation is used to indicate that the
// interface provides the mechanism for storage, retrieval, search, update and delete operation on objects.

import com.dev.kynet.demospringbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Generic types are used here
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

}
