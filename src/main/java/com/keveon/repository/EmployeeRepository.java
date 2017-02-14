package com.keveon.repository;

import com.keveon.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

/**
 * Created by Keveon on 2017/2/14.
 * 员工仓库
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    /**
     * 通过入职日期区间查询符合条件的员工信息, 并分页
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param pageable  分页请求
     * @return 符合条件的员工信息
     */
    Page<Employee> findByTurnoverDateBetween(Date startDate, Date endDate, Pageable pageable);

    /**
     * 通过工作状态查询员工信息
     *
     * @param status   工作状态
     * @param pageable 分页请求
     * @return 符合条件的员工
     */
    Page<Employee> findByStatusIs(Boolean status, Pageable pageable);

    /**
     * 通过员工名称关键字模糊查询员工信息, 并分页
     *
     * @param name     名称关键字
     * @param pageable 分页请求
     * @return 符合条件的用户信息
     */
    Page<Employee> findByNameLike(String name, Pageable pageable);
}
