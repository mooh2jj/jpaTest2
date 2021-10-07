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

    @Id
    private Long empno;

    private String ename;
    private String job;
    private int mgr;
    private Timestamp hiredate;
    private int sal;
    private int comm;

    @ManyToOne
    @JoinColumn(name = "deptno", nullable = false)
    private Dept dept;
}
