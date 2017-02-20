package com.keveon.service;

import com.keveon.model.Dept;
import com.keveon.model.Employee;
import com.keveon.model.EmployeeLevel;
import com.keveon.model.condition.EmployeeCondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Keveon on 2017/2/17.
 * 员工信息逻辑单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
@ActiveProfiles("test")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)   // 使用方法名指定测试顺序
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService service;
    private Employee employee;
    private SimpleDateFormat simpleDateFormat;
    private Pageable pageable;
    private Page<Employee> employeePage;

    @Before
    public void setUp() throws Exception {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        employee = new Employee();

        employee.setAddress("北京");

        Date birthday = simpleDateFormat.parse("1999-1-25");
        employee.setBirthday(birthday);

        Dept dept = new Dept();
        dept.setId(1);
//        dept.setName("财务部");
        employee.setDept(dept);

        EmployeeLevel level = new EmployeeLevel();
        level.setId(1);
//        level.setName("财务专员");
        employee.setEmployeeLevel(level);

        employee.setEntryDate(simpleDateFormat.parse("2016-4-9"));
        employee.setGender(1);
        employee.setIdentity("141316199601011010");
        employee.setName("时间怪客");
        employee.setPassword("123456");
        employee.setStatus(false);
        employee.setPhone("13579246810");
        employee.setUsername("user");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_1_1_create() throws Exception {
        assertThat(service.create(employee), equalTo(true));
    }

    @Test
    public void test_1_2_create() throws Exception {
    }

    @Test
    public void test_2_1_update() throws Exception {
        employee.setId(1L);
        employee.setName("刘春燕");
        employee.setGender(0);
        service.update(employee);
        assertThat(employee.getName(), equalTo("刘春燕"));
    }

    @Test
    public void test_2_2_update() throws Exception {
    }

    @Test
    public void test_2_3_updateEmployeeGender() throws Exception {
        int result = service.updateEmployeeGender(1L, 0);
        assertThat(result, equalTo(1));
    }

    @Test
    public void test_2_4_updateEmployeePhone() throws Exception {
        int result = service.updateEmployeePhone(3L, "13512345678");
        assertThat(result, equalTo(1));
    }

    @Test
    public void test_3_1_login() throws Exception {
        boolean result = service.login("user2", "123456", "127.0.0.1");
        assertThat(result, equalTo(true));
    }

    @Test
    public void test_3_2_findOne() throws Exception {
        Employee employee = service.findOne(3L);
        assertThat(employee.getName(), equalTo("员工3"));
    }

    @Test
    public void test_3_3_listAll() throws Exception {
        List<Employee> employeeList = service.listAll();
        assertThat(employeeList.size(), greaterThanOrEqualTo(1));
    }

    @Test
    public void test_3_4_pageAll() throws Exception {
        pageable = new PageRequest(0, 10);
        employeePage = service.pageAll(pageable);
//        assertThat(employeePage.getSize(), equalTo(10));
        assertThat(employeePage.getContent().size(), equalTo(10));
    }

    @Test
    public void test_3_5_pageByTurnoverDateBetween() throws Exception {
        pageable = new PageRequest(0, 10);

        employeePage = service.pageByTurnoverDateBetween(
                simpleDateFormat.parse("2016-01-11"),   // 开始时间
                simpleDateFormat.parse("2016-1-15"),   // 结束时间
                pageable);
        assertThat(employeePage.getSize(), greaterThanOrEqualTo(1));
    }

    @Test
    public void test_3_6_pageByStatusIs() throws Exception {
        pageable = new PageRequest(0, 10);
        employeePage = service.pageByStatusIs(false, pageable);
        assertThat(employeePage.getSize(), greaterThanOrEqualTo(1));
    }

    @Test
    public void test_3_7_findByPhone() throws Exception {
        employee = service.findByPhone("13579246815");
        assertThat(employee, notNullValue());
    }

    @Test
    public void test_3_8_pageByNameLike() throws Exception {
        pageable = new PageRequest(0, 10);
        employeePage = service.pageByNameLike("员工", pageable);
        assertThat(employeePage.getSize(), greaterThanOrEqualTo(1));
    }

    @Test
    public void test_3_9_pageByCondition() throws Exception {
        pageable = new PageRequest(0, 10);
        EmployeeCondition condition = new EmployeeCondition();
        condition.setDeptName("部门2");
        employeePage = service.pageByCondition(condition, pageable);
        assertThat(employeePage.getContent().size(), equalTo(0));

        condition.setDeptName("部门1");
        condition.setLevelName("职位1");
        condition.setName("经理");
        employeePage = service.pageByCondition(condition, pageable);
        assertThat(employeePage.getContent().size(), equalTo(0));

        condition.setName("员工");
        condition.setPhone("13579246818");
        condition.setGender(0);
        employeePage = service.pageByCondition(condition, pageable);
        assertThat(employeePage.getContent().size(), equalTo(0));

        condition.setGender(1);
        employeePage = service.pageByCondition(condition, pageable);
        assertThat(employeePage.getContent().size(), equalTo(1));
    }

    @Test
    public void test_4_1_remove() throws Exception {
        service.remove(16L);
    }

    @Test
    public void test_4_2_remove() throws Exception {
        employee.setId(13L);
        service.remove(employee);
    }
}