package com.keveon.repository;

import com.keveon.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by Keveon on 2017/2/14.
 * 员工仓库
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    /**
     * 通过员工编号修改员工性别
     *
     * @param id     员工编号
     * @param gender 性别
     * @return 修改结果
     */
    @Modifying
    @Query(value = "UPDATE m_employee e SET e.emp_gender = :gender WHERE e.emp_id = :id", nativeQuery = true)
    Integer updateEmployeeGender(@Param("id") Long id, @Param("gender") Integer gender);

    /**
     * 通过员工编号修改用户手机号
     *
     * @param id    用户编号
     * @param phone 用户手机号
     * @return 修改结果
     */
    @Modifying
    @Query(value = "UPDATE m_employee e SET e.emp_phone = ?2 WHERE e.emp_id = ?1", nativeQuery = true)
    Integer updateEmployeePhoneAAA(Long id, String phone);

    /**
     * 通过用户名及密码查询用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
//    @Query("FROM Employee e WHERE e.username = ?1 AND e.password = ?2")
    Employee findByUsernameAndPasswordBBB(String username, String password);

    /**
     * 通过员工手机号码查询员工信息
     *
     * @param phone 员工手机号
     * @return 员工信息
     */
//    @Query(value = "SELECT m_employee e WHERE e.emp_phone = :phone", nativeQuery = true)
    Employee findByPhone(@Param("phone") String phone);

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
