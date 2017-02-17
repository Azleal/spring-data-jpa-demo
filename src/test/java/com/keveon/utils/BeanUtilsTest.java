package com.keveon.utils;

import com.keveon.model.Dept;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

/**
 * Created by user on 2017/2/17.
 * Bean工具类单元测试
 */
public class BeanUtilsTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void copyTo() throws Exception {
		Dept formDept = new Dept();
		formDept.setId(1);
		formDept.setName("部门1");

		Dept toDept = new Dept();
		toDept.setId(2);
		toDept.setName("部门2");
		toDept.setEmployees(new ArrayList<>());

		BeanUtils.copyTo(formDept, toDept);
		assertThat(toDept.getName(), equalToIgnoringCase("部门1"));
	}

}