package com.keveon.service;

import com.keveon.model.EmployeeDetail;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

/**
 * Created by Keveon on 2017/2/14.
 * 员工登录详情单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)   // 使用方法名指定测试顺序
public class EmployeeDetailServiceTest {

    @Autowired
    private EmployeeDetailService service;
    private EmployeeDetail detail;

    @Before
    public void setUp() throws Exception {
        detail = new EmployeeDetail();
        detail.setId(1L);
        detail.setLoginTime(new Date());
        detail.setLoginIp("127.0.0.1");
        detail.setLoginCount(3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_1_1_save() throws Exception {
        isTrue(service.save(detail));
    }

    @Test
    public void test_3_1_findOne() throws Exception {
        notNull(service.findOne(1L));
    }

    @Test
    public void test_4_1_delete() throws Exception {
        service.delete(1L);
    }

}