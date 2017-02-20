package com.keveon.service.impl;

import com.keveon.model.EmployeeDetail;
import com.keveon.repository.EmployeeDetailRepository;
import com.keveon.service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

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
    public Boolean setLogin(Long id, String ip) {
        EmployeeDetail detail = findOne(id);

        Assert.notNull(detail, "登录信息不存在, 修改失败.");

        detail.setLoginCount(detail.getLoginCount() + 1);
        detail.setLoginIp(ip);
        detail.setLoginTime(new Date());

        detail = repository.save(detail);
        return !ObjectUtils.isEmpty(detail) && !StringUtils.isEmpty(detail.getId());
    }

    @Override
    public EmployeeDetail findOne(Long id) {
        return repository.findOne(id);
    }
}
