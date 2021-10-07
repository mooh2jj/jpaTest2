package com.example.jpatest2.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString(exclude = "dept")
@NoArgsConstructor
@Table(name = "emp")
public class Emp {

    public Emp(Long empno, String ename, String job, Integer mgr, Timestamp hiredate, Integer sal, Integer comm, Long deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        Dept dept = new Dept();
        dept.setDeptno(deptno);
        this.dept = dept;
    }

    @Id
    private Long empno;

    private String ename;
    private String job;
    private Integer mgr;
    private Timestamp hiredate;
    private Integer sal;
    private Integer comm;

    @ManyToOne
    @JoinColumn(name = "deptno", nullable = false)
    private Dept dept;
}
