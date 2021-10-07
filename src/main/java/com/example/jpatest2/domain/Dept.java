package com.example.jpatest2.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString(exclude = "empList")
@Entity
@NoArgsConstructor
@Table(name = "dept")
public class Dept {

    public Dept(Long deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    @Id
    private Long deptno;

    private String dname;

    private String loc;

    @OneToMany(mappedBy = "dept", fetch = FetchType.LAZY)
    private List<Emp> empList;

}
