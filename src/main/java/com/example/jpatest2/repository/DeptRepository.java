package com.example.jpatest2.repository;

import com.example.jpatest2.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Long> {

}
