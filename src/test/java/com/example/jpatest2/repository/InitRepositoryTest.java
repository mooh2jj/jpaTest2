package com.example.jpatest2.repository;

import com.example.jpatest2.domain.Dept;
import com.example.jpatest2.domain.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class InitRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private EmpRepository empRepository;

    @Test
    @Transactional
    void A001_deleteAll() {

        empRepository.deleteAll();          // 순서가 중요! 이거참조하는 거(emp -> dept 참조)부터 지워야
        deptRepository.deleteAll();

    }

    @Test
    void A001_insertAll() {

        List<Dept> deptList = new ArrayList<Dept>();
        Dept dept10 = new Dept(10L, "ACCOUNTING", "NEW YORK");
        deptList.add(dept10);
        Dept dept15 = new Dept(15L, "TEST", "TOKYO");
        deptList.add(dept15);
        Dept dept20 = new Dept(20L, "RESEARCH", "DALLAS");
        deptList.add(dept20);
        Dept dept30 = new Dept(30L, "SALES", "CHICAGO");
        deptList.add(dept30);
        Dept dept40 = new Dept(40L, "OPERATIONS", "BOSTON");
        deptList.add(dept40);

        deptRepository.saveAll(deptList);

        List<Emp> empList = new ArrayList<Emp>();
        Emp emp;
        emp = new Emp(7000L, "KING", "CLERK", null, getTimestamp("1981-11-17 00:00:00 .000"), 5000, null, 10L);
        empList.add(emp);
        emp = new Emp(7001L, "Black", "MANAGER", 7000, getTimestamp("2011-05-17 00:00:00 .000"), 4600, null, 30L);
        empList.add(emp);
        emp = new Emp(7002L, "White", "MANAGER", 7000, getTimestamp("1971-04-17 00:00:00 .000"), 6000, null, 10L);
        empList.add(emp);
        emp = new Emp(7003L, "Pink", "MANAGER", 7000, getTimestamp("1981-11-17 00:00:00 .000"), 5000, 300, 20L);
        empList.add(emp);
        emp = new Emp(7004L, "Yellow", "ANALYST", 7004, getTimestamp("1990-02-17 00:00:00 .000"), 3000, 500, 20L);
        empList.add(emp);
        emp = new Emp(7005L, "Red", "ANALYST", 7005, getTimestamp("1981-10-17 00:00:00 .000"), 2400, 1400, 30L);
        empList.add(emp);
        emp = new Emp(7006L, "Blue", "SALESMAN", 7003, getTimestamp("2004-01-17 00:00:00 .000"), 7000, 0, 10L);
        empList.add(emp);

        empRepository.saveAll(empList);
        
    }

    private Timestamp getTimestamp(String timestamp) {

        LocalDateTime localDateTime = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss .SSS"));
        return Timestamp.valueOf(localDateTime);
    }


}