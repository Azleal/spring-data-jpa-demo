package com.keveon.repository;

import com.keveon.model.EmployeeDetail;
import org.springframework.data.repository.Repository;

/**
 * Created by Keveon on 2017/2/14.
 * 员工登录详情仓库
 */
public interface EmployeeDetailRepository extends Repository<EmployeeDetail, Long> {
    /**
     * 持久化登录信息登录信息信息
     * 如果信息已经存在, 修改, 反之, 新增
     *
     * @param employeeDetail 登录信息信息
     * @return .
     */
    EmployeeDetail save(EmployeeDetail employeeDetail);

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
