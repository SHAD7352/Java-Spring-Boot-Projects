package com.dillutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dillutech.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
