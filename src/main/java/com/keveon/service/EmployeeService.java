package com.keveon.service;

import com.keveon.model.Employee;
import com.keveon.model.condition.EmployeeCondition;
import com.keveon.model.vo.EmployeeVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Keveon on 2017/2/14.
 * 员工信息逻辑
 */
public interface EmployeeService {

    /**
     * 新增员工
     *
     * @param employee 员工信息
     * @return 新增结果
     */
    Boolean create(Employee employee);

    /**
     * 批量信息员工信息
     *
     * @param employeeList 员工信息集合
     * @return 新增结果
     * 返回的Map包含两个Key, success(true) 和 failure(false), 对应的值分别为成功或失败的条数
     */
    Map<Boolean, Integer> create(List<Employee> employeeList);

    /**
     * 通过员工编号删除员工信息
     *
     * @param id 员工信息编号
     */
    void remove(Integer id);

    /**
     * 删除员工信息
     *
     * @param employee 员工信息
     */
    void remove(Employee employee);

    /**
     * 更新员工
     *
     * @param employee 员工信息
     * @return 更新结果
     */
    Boolean update(Employee employee);

    /**
     * 批量信息员工信息
     *
     * @param employeeList 员工信息集合
     * @return 更新结果
     * 返回的Map包含两个Key, success(true) 和 failure(false), 对应的值分别为成功或失败的条数
     */
    Map<Boolean, Integer> update(List<Employee> employeeList);

    /**
     * 查询全部员工信息
     *
     * @return 员工信息
     */
    List<EmployeeVo> listAll();

    /**
     * 查询全部员工信息并分页
     *
     * @return 分页后的员工信息
     */
    Page<EmployeeVo> pageAll(Pageable pageable);

    /**
     * 通过入职日期区间查询符合条件的员工信息, 并分页
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param pageable  分页请求
     * @return 符合条件的员工信息
     */
    Page<EmployeeVo> findByTurnoverDateBetween(Date startDate, Date endDate, Pageable pageable);

    /**
     * 通过工作状态查询员工信息
     *
     * @param status   工作状态
     * @param pageable 分页请求
     * @return 符合条件的员工
     */
    Page<EmployeeVo> findByStatusIs(Boolean status, Pageable pageable);

    /**
     * 通过员工名称关键字模糊查询员工信息, 并分页
     *
     * @param name     名称关键字
     * @param pageable 分页请求
     * @return 符合条件的用户信息
     */
    Page<EmployeeVo> findByNameLike(String name, Pageable pageable);

    /**
     * 动态查询员工信息
     *
     * @param employeeCondition 员工信息查询条件, 并分页
     * @param pageable          分页请求
     * @return 符合条件并分页后的员工信息
     */
    Page<EmployeeVo> pageByCondition(EmployeeCondition employeeCondition, Pageable pageable);
}
