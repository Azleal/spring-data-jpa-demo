package com.keveon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	/*
     * 以下这段话纯属为了解释方法命名比较乱原因, 所以自己定的一种命名的方式, 嫌码放的直接略过吧.
     *
     * 为区分JUnit运行顺序, 同时区分测试的方法, 特固定单元测试方法命名为
     * test_testType_testNum_methodName() 的方式,方法名中,
     *   第一个出现的数字(testType)的含义如下:
     *      1: 增加(例: test_1_1_create())
     *      2: 修改(例: test_2_1_patch())
     *      3: 查询(例: test_3_1_findAll())
     *      4: 删除(例: test_4_1_deleteById())
     *   第二个出现的数字(testNum)的含义为第n个 {testType} 方法
     */

	@Test
	public void contextLoads() {
	}

}
