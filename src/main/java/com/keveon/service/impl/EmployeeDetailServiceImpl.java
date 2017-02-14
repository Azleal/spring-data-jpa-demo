package com.keveon.service.impl;

import com.keveon.model.EmployeeDetail;
import com.keveon.repository.EmployeeDetailRepository;
import com.keveon.service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * Created by Keveon on 2017/2/14.
 * 员工登录详情逻辑接口实现
 */
@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService {

    private final EmployeeDetailRepository repository;

    @Autowired
    public EmployeeDetailServiceImpl(EmployeeDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean save(EmployeeDetail employeeDetail) {
        employeeDetail = repository.save(employeeDetail);
        return !ObjectUtils.isEmpty(employeeDetail) && !StringUtils.isEmpty(employeeDetail.getId());
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public EmployeeDetail findOne(Long id) {
        return repository.findOne(id);
    }
}
