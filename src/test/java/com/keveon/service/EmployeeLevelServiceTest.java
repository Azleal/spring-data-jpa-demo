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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Keveon on 2017/2/15.
 * 职位信息逻辑单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles("test")
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
		level.setId(1);
		level.setName("总经理");
		assertThat(service.update(level), equalTo(true));
	}

	@Test
    public void test_3_1_findByNameLike() throws Exception {
        assertThat(service.findByNameLike("职位").size(), greaterThanOrEqualTo(1));
	}

    @Test
    public void test_3_2_pageAll_1() throws Exception {
        Pageable pageable = new PageRequest(0, 10);

        assertThat(service.pageAll(pageable).getSize(), greaterThanOrEqualTo(1));
    }

    @Test
    public void test_3_2_pageAll_2() throws Exception {
        Pageable pageable = new PageRequest(0, 10, Sort.Direction.DESC, "id");

        assertThat(service.pageAll(pageable).getContent().get(0).getId(), equalTo(20));
    }

    @Test
	public void test_4_1_remove() throws Exception {
		service.remove(1);
	}

	@Test
	public void test_4_2_remove() throws Exception {
		service.remove(level);
	}

}