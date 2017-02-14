package com.keveon.model.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Keveon on 2017/2/14.
 * 员工信息展示对象
 */
@Data
@RequiredArgsConstructor
public class EmployeeVo implements Serializable {
    private static final long serialVersionUID = 4717567749949031641L;
    /**
     * 员工ID
     */
    Long id;

    /**
     * 员工姓名
     */
    String name;

    /**
     * 密码
     */
    String password;

    /**
     * 员工手机号
     */
    String phone;

    /**
     * 身份证号码
     */
    String identity;

    /**
     * 员工性别
     */
    Boolean gender;

    /**
     * 员工出生日期
     */
    Date birthday;

    /**
     * 年龄
     */
    Integer age;

    /**
     * 详细地址
     */
    String address;

    /**
     * 工作状态
     * true => 空闲
     * false => 忙碌
     */
    Boolean status;

    /**
     * 入职日期
     */
    Date entryDate;

    /**
     * 离职日期
     */
    Date turnoverDate;

    /**
     * 所在部门
     */
    String deptName;

    /**
     * 职位
     */
    String levelName;

    /**
     * 上次登录IP
     */
    String loginIp;

    /**
     * 登录次数
     */
    Integer loginCount;
}
