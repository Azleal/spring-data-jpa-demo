package com.keveon.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Keveon on 2017/2/14.
 * 部门信息
 */
@Entity
@Table(name = "m_dept")
@Data
@RequiredArgsConstructor
public class Dept implements Serializable {
    private static final long serialVersionUID = -8459755922288527580L;

    /**
     * 部门编号
     */
    @Id
    @Column(name = "dept_id")
    @GeneratedValue
    Integer id;

    /**
     * 部门名称
     */
    @Column(name = "dept_name", length = 10)
    String name;

    /**
     * 员工信息
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dept")
    List<Employee> employees;
}
