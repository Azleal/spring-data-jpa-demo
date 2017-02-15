package com.keveon.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Keveon on 2017/2/14.
 * 职位
 */
@Entity
@Table(name = "m_employee_level")
@Data
@RequiredArgsConstructor
public class EmployeeLevel implements Serializable {
    private static final long serialVersionUID = 39445974064595266L;

    /**
     * 编号
     */
    @Id
    @Column(name = "level_id")
    @GeneratedValue
    Integer id;

    /**
     * 职位名称
     */
    @Column(name = "level_name")
    String name;
}
