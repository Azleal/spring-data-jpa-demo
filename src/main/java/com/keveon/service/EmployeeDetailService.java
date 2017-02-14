package com.keveon.service;

import com.keveon.model.EmployeeDetail;

/**
 * Created by Keveon on 2017/2/14.
 * 员工登录详情逻辑
 */
public interface EmployeeDetailService {
    /**
     * 持久化登录信息登录信息信息
     * 如果信息已经存在, 修改, 反之, 新增
     *
     * @param employeeDetail 登录信息信息
     * @return 新增结果
     */
    Boolean save(EmployeeDetail employeeDetail);

    /**
     * 通过登录信息编号删除登录信息信息
     *
     * @param id 登录信息编号
     */
    void delete(Long id);

    /**
     * 通过登录信息编号查询登录信息信息
     *
     * @param id 登录信息编号
     * @return 登录信息信息
     */
    EmployeeDetail findOne(Long id);
}
