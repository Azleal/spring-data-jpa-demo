package com.keveon.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Keveon on 2017/2/14.
 * 登录信息
 */
@Entity
@Table(name = "m_employee_detail")
@Data
@RequiredArgsConstructor
public class EmployeeDetail implements Serializable {

    private static final long serialVersionUID = 3644201788265604958L;

    /**
     * 员工ID
     */
    @Id
    @Column(name = "emp_id")
    Long id;

    /**
     * 上次登录时间
     */
    @Column(name = "emp_last_login_time")
    @Temporal(TemporalType.TIMESTAMP)
    Date loginTime;

    /**
     * 上次登录IP
     */
    @Column(name = "emp_last_login_ip", length = 15)
    String loginIp;

    /**
     * 登录次数
     */
    @Column(name = "emp_login_count")
    Integer loginCount;
}
