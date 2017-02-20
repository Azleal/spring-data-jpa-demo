package com.keveon.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Keveon on 2017/2/14.
 * 员工信息
 */
@Entity
@Table(name = "m_employee")
@Data
@RequiredArgsConstructor
@NamedNativeQueries(value = {
        @NamedNativeQuery(name = "Employee.findByPhoneAAA", query = "SELECT m_employee e WHERE e.emp_phone = :phone")
})
@NamedQueries(value = {
        @NamedQuery(name = "Employee.findByUsernameAndPasswordBBB", query = "FROM Employee e WHERE e.username = ?1 AND e.password = ?2")
})
public class Employee implements Serializable {
    private static final long serialVersionUID = -1426297524794331156L;
    /**
     * 员工ID
     */
    @Id
    @Column(name = "emp_id")
    @GeneratedValue
    Long id;

    /**
     * 员工姓名
     */
    @Column(name = "emp_name", length = 10)
    String name;

    /**
     * 登录名
     */
    @Column(name = "emp_username", length = 10, unique = true)
    String username;

    /**
     * 密码
     */
    @Column(name = "emp_password", length = 50)
    String password;

    /**
     * 员工手机号
     */
    @Column(name = "emp_phone", length = 11, unique = true)
    String phone;

    /**
     * 身份证号码
     */
    @Column(name = "emp_identity", length = 18, unique = true)
    String identity;

    /**
     * 员工性别
     */
    @Column(name = "emp_gender")
    Integer gender;

    /**
     * 员工出生日期
     */
    @Column(name = "emp_birthday")
    @Temporal(TemporalType.DATE)
    Date birthday;

    /**
     * 详细地址
     */
    @Column(name = "emp_address")
    String address;

    /**
     * 工作状态
     * true => 空闲
     * false => 忙碌
     */
    @Column(name = "emp_status")
    Boolean status;

    /**
     * 入职日期
     */
    @Column(name = "emp_entryDate")
    @Temporal(TemporalType.DATE)
    Date entryDate;

    /**
     * 离职日期
     */
    @Column(name = "emp_turnoverDate")
    @Temporal(TemporalType.DATE)
    Date turnoverDate;

    /**
     * 所在部门
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "dept_id")
    Dept dept;

    /**
     * 职位
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "level_id")
    EmployeeLevel employeeLevel;
}
