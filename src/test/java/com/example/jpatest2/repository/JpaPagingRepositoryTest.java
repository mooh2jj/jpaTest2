package com.example.jpatest2.repository;

import com.example.jpatest2.domain.Dept;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@Slf4j
@SpringBootTest
class JpaPagingRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;

    @Test
    void A001_search() {
        deptRepository.findByDnameContaining("A").forEach(d -> {
//            log.debug(d.toString());
            System.out.println(d.toString());
        });

    }

    @Test
    void A002_search() {
        deptRepository.findByDnameContainingOrderByDnameAsc("A").forEach(d -> {
//            log.debug(d.toString());
            System.out.println(d.toString());
        });

    }

    @Test
    void A003_search() {
        var count = deptRepository.countByDnameContaining("A");

        System.out.println("count: "+String.valueOf(count));
    }

    /**
     * Paging test
     */
    @Test
    void A004_search() {

        List<Dept> deptList = new ArrayList<>();

        LongStream.rangeClosed(1,999L).forEach(i -> {
            Dept dept = new Dept();
            dept.setDeptno(i);
            dept.setDname(i + "th name");
            deptList.add(dept);
        });

        deptRepository.saveAll(deptList);
    }

    @Test
    void A005_search() {

        String searchDname = "9";

        Long count = deptRepository.countByDnameContaining(searchDname);
        // 페이지마다 사이즈
        int pageSize = 10;

        int pageCnt = (int) (count / pageSize);

        for (int i = 0; i < pageCnt + 1; i++) {
            System.out.println("========> [" + (i + 1) +"] page");
             Pageable pageable = PageRequest.of(i, pageSize, Sort.Direction.DESC, "dname");

            deptRepository.findByDnameContaining(searchDname, pageable).forEach(d -> {
                System.out.println(d.toString());
            });
        }
    }

}