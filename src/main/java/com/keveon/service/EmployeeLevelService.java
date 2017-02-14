package com.keveon.service;

import com.keveon.model.Dept;
import com.keveon.model.EmployeeLevel;

import java.util.List;
import java.util.Map;

/**
 * Created by Keveon on 2017/2/14.
 * 职位信息逻辑
 */
public interface EmployeeLevelService {
    /**
     * 新增职位
     *
     * @param employeeLevel 职位信息
     * @return 新增结果
     */
    Boolean create(EmployeeLevel employeeLevel);

    /**
     * 批量信息职位信息
     *
     * @param employeeLevelList 职位信息集合
     * @return 新增结果
     * 返回的Map包含两个Key, success(true) 和 failure(false), 对应的值分别为成功或失败的条数
     */
    Map<Boolean, Integer> create(List<EmployeeLevel> employeeLevelList);

    /**
     * 通过职位编号删除职位信息
     *
     * @param id 职位信息编号
     */
    void remove(Integer id);

    /**
     * 删除职位信息
     *
     * @param employeeLevel 职位信息
     */
    void remove(EmployeeLevel employeeLevel);

    /**
     * 更新职位
     *
     * @param employeeLevel 职位信息
     * @return 更新结果
     */
    Boolean update(EmployeeLevel employeeLevel);

    /**
     * 批量信息职位信息
     *
     * @param employeeLevelList 职位信息集合
     * @return 更新结果
     * 返回的Map包含两个Key, success(true) 和 failure(false), 对应的值分别为成功或失败的条数
     */
    Map<Boolean, Integer> update(List<EmployeeLevel> employeeLevelList);

    /**
     * 通过部门名称关键字模糊查询部门信息
     *
     * @param name 部门名称关键字
     * @return 符合条件的部门的信息
     */
    List<Dept> findByNameLike(String name);
}
