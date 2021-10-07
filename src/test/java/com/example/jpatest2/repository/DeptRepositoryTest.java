package com.example.jpatest2.repository;

import com.example.jpatest2.domain.Dept;
import com.example.jpatest2.domain.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private EmpRepository empRepository;

    @Test
    void A001_insert() {

        Dept dept = new Dept();
        dept.setDeptno(10L);
        dept.setDname("10name");
        dept.setLoc("10Loc");

        System.out.println(deptRepository.save(dept));

        Emp emp = new Emp();
        emp.setEmpno(10L);
        emp.setEname("10ename");
        emp.setDept(dept);

        System.out.println(empRepository.save(emp));
    }

    @Test
    void A002_read() {

//        var dept = deptRepository.findById(10L).orElse(null);

        if (deptRepository.findById(10L).isPresent()) {
            System.out.println(deptRepository.findById(10L).get());
//            System.out.println(deptRepository.findById(10L).get().getEmpList());  // LAZY 쓰면 안나옴 -> @Query문 써야함!
            System.out.println(deptRepository.getDeptDeptno(10L));
        } else {
            System.out.println("no fouund data!");
        }

//        System.out.println("Dept_read: " + dept);

        if (empRepository.findById(10L).isPresent()) {
            System.out.println(empRepository.findById(10L).get());
        } else {
            System.out.println("no fouund data!");
        }

    }


    @Test
    void A003_update() {
        var dept = deptRepository.findById(10L).get();

        dept.setDname("changedName");
        dept.setLoc("changedLoc");

        System.out.println(deptRepository.save(dept));

        var emp = empRepository.findById(10L).get();

        emp.setEname("changedeame");
        emp.setJob("changedJob");

        System.out.println(empRepository.save(emp));
    }

    @Test
    void A003_delete() {

        var dept = deptRepository.findById(2L).get();

        deptRepository.delete(dept);

    }
}