package com.keveon.service.impl;

import com.keveon.model.EmployeeLevel;
import com.keveon.repository.EmployeeLevelRepository;
import com.keveon.service.EmployeeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Keveon on 2017/2/15.
 * 职位信息逻辑接口实现
 */
@Service
public class EmployeeLevelServiceImpl implements EmployeeLevelService {

    private final EmployeeLevelRepository repository;

    @Autowired
    public EmployeeLevelServiceImpl(EmployeeLevelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean create(EmployeeLevel employeeLevel) {
        employeeLevel = repository.save(employeeLevel);
        return !ObjectUtils.isEmpty(employeeLevel) && !StringUtils.isEmpty(employeeLevel.getId());
    }

    @Override
    public void remove(Integer id) {
        repository.delete(id);
    }

    @Override
    public void remove(EmployeeLevel employeeLevel) {
        repository.delete(employeeLevel);
    }

    @Override
    public Boolean update(EmployeeLevel employeeLevel) {
        // todo 判断无值的字段, 避免将本不准备修改的值改为null

        employeeLevel = repository.save(employeeLevel);
        return !ObjectUtils.isEmpty(employeeLevel) && !StringUtils.isEmpty(employeeLevel.getId());
    }

    @Override
    public List<EmployeeLevel> findByNameLike(String name) {
        return repository.findByNameLike("%" + name + "%");
    }
}
