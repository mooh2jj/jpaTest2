package com.example.jpatest2.repository;

import com.example.jpatest2.domain.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;

    @Test
    void A001_insert() {

        Dept dept = new Dept();
        dept.setDname("10name");
        dept.setLoc("10Loc");

        System.out.println(deptRepository.save(dept));

    }

    @Test
    void A002_read() {

//        var dept = deptRepository.findById(10L).orElse(null);

        if (deptRepository.findById(10L).isPresent()) {
            System.out.println(deptRepository.findById(10L).get());
        } else {
            System.out.println("no fouund data!");
        }

//        System.out.println("Dept_read: " + dept);
    }


    @Test
    void A003_update() {
        var dept = deptRepository.findById(2L).get();

        dept.setDname("changedName");
        dept.setLoc("changedLoc");

        System.out.println(deptRepository.save(dept));
    }

    @Test
    void A003_delete() {

        Dept dept = new Dept();
        dept.setDetno(1L);

        deptRepository.delete(dept);

    }
}