package com.example.jpatest2.repository;

import com.example.jpatest2.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeptRepository extends JpaRepository<Dept, Long> {

    @Query("select d from Dept d inner join Emp e on d.deptno = e.dept.deptno where d.deptno =:deptno")
    public Dept getDeptDeptno(Long deptno);
}
