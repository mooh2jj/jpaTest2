package com.example.jpatest2.repository;

import com.example.jpatest2.domain.Dept;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept, Long> {

    /**
     * 부서명 검색
     * @param dname
     * @return
     */
    List<Dept> findByDnameContaining(String dname);

    /**
     * 부서명 검색, 오름차순
     * @param dname
     * @return
     */
    List<Dept> findByDnameContainingOrderByDnameAsc(String dname);

    /**
     * 부서명 검색 결과 갯수
     * @param dname
     * @return
     */
    Long countByDnameContaining(String dname);

//    /**
//     * 부서명 검색, 페이징
//     * @param dname
//     * @param pageable
//     * @return
//     */
    List<Dept> findByDnameContaining(String dname, Pageable pageable);

    @Query("select d from Dept d inner join Emp e on d.deptno = e.dept.deptno where d.deptno =:deptno")
    public Dept getDeptDeptno(Long deptno);
}
