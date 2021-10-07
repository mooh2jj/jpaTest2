package com.example.jpatest2.repository;

import com.example.jpatest2.domain.Dept;
import com.example.jpatest2.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp, Long> {

}
