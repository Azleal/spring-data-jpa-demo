package com.keveon.service.impl;

import com.keveon.model.Employee;
import com.keveon.model.EmployeeLevel;
import com.keveon.model.condition.EmployeeCondition;
import com.keveon.repository.EmployeeRepository;
import com.keveon.service.EmployeeDetailService;
import com.keveon.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

/**
 * Created by Keveon on 2017/2/17.
 * 员工信息逻辑接口实现
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeDetailService employeeDetailService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeDetailService employeeDetailService) {
        this.repository = repository;
        this.employeeDetailService = employeeDetailService;
    }

    @Override
    public Boolean create(Employee employee) {
        employee = repository.save(employee);
        return !ObjectUtils.isEmpty(employee) && !StringUtils.isEmpty(employee.getId());
    }

    @Override
    public Iterable<Employee> create(List<Employee> employeeList) {
        return null;
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }

    @Override
    public void remove(Employee employee) {
        Assert.notNull(employee, "要删除的员工信息不能为空!");
        Assert.notNull(employee.getId(), "要删除的员工编号不能为空!");
        repository.delete(employee);
    }

    @Override
    public Boolean update(Employee employee) {
        Assert.notNull(employee.getId(), "员工编号不能为空!");

        Employee tempEmployee = findOne(employee.getId());
        Assert.notNull(tempEmployee, "员工信息不存在.修改失败!");

        BeanUtils.copyProperties(employee, tempEmployee);

        employee = repository.save(employee);
        return !ObjectUtils.isEmpty(employee) && !StringUtils.isEmpty(employee.getId());
    }

    @Override
    public Iterable<Employee> update(List<Employee> employeeList) {
        return null;
    }

    @Override
    @Transactional
    public Integer updateEmployeeGender(Long id, Integer gender) {
        return repository.updateEmployeeGender(id, gender);
    }

    @Override
    @Transactional
    public Integer updateEmployeePhone(Long id, String phone) {
        return repository.updateEmployeePhoneAAA(id, phone);
    }

    @Override
    public Boolean login(String username, String password, String ip) {
        Assert.notNull(username, "用户名不能为空!");
        Assert.notNull(password, "密码不能为空!");

        Employee tempEmployee = repository.findByUsernameAndPasswordBBB(username, password);
        Assert.notNull(tempEmployee, "登录信息不存在, 失败!");

        return employeeDetailService.setLogin(tempEmployee.getId(), ip);
    }

    @Override
    public Employee findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Employee> listAll() {
        return repository.findAll();
    }

    @Override
    public Page<Employee> pageAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Employee> pageByTurnoverDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByTurnoverDateBetween(startDate, endDate, pageable);
    }

    @Override
    public Page<Employee> pageByStatusIs(Boolean status, Pageable pageable) {
        return repository.findByStatusIs(status, pageable);
    }

    @Override
    public Employee findByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    @Override
    public Page<Employee> pageByNameLike(String name, Pageable pageable) {
        return repository.findByNameLike("%" + name + "%", pageable);
    }

    @Override
    public Page<Employee> pageByCondition(EmployeeCondition condition, Pageable pageable) {
        return repository.findAll((root, query, cb) -> {
            // 查询条件
            List<Predicate> predicates = new ArrayList<>();

            // 员工姓名
            if (hasText(condition.getName()))
                predicates.add(cb.like(root.get("name").as(String.class), "%" + condition.getName() + "%"));

            // 员工手机号
            if (hasText(condition.getPhone()))
                predicates.add(cb.equal(root.get("phone").as(String.class), condition.getPhone()));

            // 身份证号码
            if (hasText(condition.getIdentity()))
                predicates.add(cb.equal(root.get("identity").as(String.class), condition.getIdentity()));

            // 员工性别
            if (null != condition.getGender())
                predicates.add(cb.equal(root.get("gender").as(String.class), condition.getGender()));

            // 工作状态
            if (null != condition.getStatus())
                predicates.add(cb.equal(root.get("status").as(String.class), condition.getStatus()));

            // 所在部门名称
            if (hasText(condition.getDeptName()))

                // 表连接方式1
                predicates.add(cb.like(root.join("dept").get("name").as(String.class), "%" + condition.getDeptName() + "%"));

            // 职位名称
            if (hasText(condition.getLevelName())) {

                // 表连接方式2
                Join<Employee, EmployeeLevel> join = root.join(root.getModel().getSingularAttribute("employeeLevel", EmployeeLevel.class), JoinType.LEFT);
                predicates.add(cb.like(join.get("name"), "%" + condition.getLevelName() + "%"));
            }

            // 加入条件
            query.where(predicates.toArray(new Predicate[predicates.size()]));
            return null; // 返回null或别的都无所谓
        }, pageable);
    }
}
