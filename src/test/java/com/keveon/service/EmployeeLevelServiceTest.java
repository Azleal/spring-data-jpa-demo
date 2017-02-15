package com.keveon.service;

import com.keveon.model.EmployeeLevel;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Keveon on 2017/2/15.
 * 职位信息逻辑单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)   // 使用方法名指定测试顺序
public class EmployeeLevelServiceTest {

    @Autowired
    private EmployeeLevelService service;
    private EmployeeLevel level;

    @Before
    public void setUp() throws Exception {
        level = new EmployeeLevel();
//        level.setId(1);
        level.setName("客户经理");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_1_create() throws Exception {
        assertThat(service.create(level), equalTo(true));
    }

    @Test
    public void test_2_update() throws Exception {
        level.setName("总经理");
        assertThat(service.update(level), equalTo(true));
    }

    @Test
    public void test_3_findByNameLike() throws Exception {
        assertThat(service.findByNameLike("经理").size(), greaterThanOrEqualTo(1));
    }

    @Test
    @Transactional
    public void test_4_1_remove() throws Exception {
        service.remove(1);
    }

    @Test
    public void test_4_2remove() throws Exception {
        service.remove(level);
    }

}