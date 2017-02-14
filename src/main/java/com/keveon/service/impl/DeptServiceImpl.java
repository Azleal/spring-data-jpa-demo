package com.keveon.service.impl;

import com.keveon.model.Dept;
import com.keveon.repository.DeptRepository;
import com.keveon.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Keveon on 2017/2/14.
 * 部门信息逻辑接口实现
 */
@Service
public class DeptServiceImpl implements DeptService {

    private final DeptRepository repository;

    @Autowired
    public DeptServiceImpl(DeptRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean save(Dept dept) {
        dept = repository.save(dept);
        return !ObjectUtils.isEmpty(dept) && !StringUtils.isEmpty(dept.getId());
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public void delete(Dept dept) {
        repository.delete(dept);
    }

    @Override
    public Boolean update(Dept dept) {
        // todo 判断无值的字段, 避免将本不准备修改的值改为null

        dept = repository.save(dept);
        return !ObjectUtils.isEmpty(dept) && !StringUtils.isEmpty(dept.getId());
    }

    @Override
    public Dept findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<Dept> findByNameLike(String name) {
        return repository.findByNameLike("%" + name + "%");
    }
}
