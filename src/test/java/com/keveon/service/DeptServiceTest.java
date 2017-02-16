package com.keveon.service;

import com.keveon.model.Dept;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Keveon on 2017/2/14.
 * 部门信息逻辑单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)   // 使用方法名指定测试顺序
public class DeptServiceTest {

    @Autowired
    private DeptService service;
    private Dept dept;

    @Before
    public void setUp() throws Exception {
        dept = new Dept();
//        dept.setId(1);
		dept.setName("研发部");
	}

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_1_save() throws Exception {
        assertThat(service.save(dept), equalTo(true));
    }

    @Test
    public void test_2_update() throws Exception {
		dept.setName("测试部");
		assertThat(service.update(dept), equalTo(true));
    }

    @Test
    public void test_3_1_findOne() throws Exception {
		assertThat(service.findOne(1).getName(), containsString("部"));
	}

    @Test
    public void test_3_2_findByNameLike() throws Exception {
		assertThat(service.findByNameLike("部").size(), greaterThanOrEqualTo(1));
	}

    @Test
    public void test_4_1_delete() throws Exception {
        service.delete(1);
    }

    @Test
    public void test_4_2_delete() throws Exception {
        service.delete(dept);
    }
}