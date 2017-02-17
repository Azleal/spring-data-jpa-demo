package com.keveon.service.impl;

import com.keveon.model.EmployeeLevel;
import com.keveon.repository.EmployeeLevelRepository;
import com.keveon.service.EmployeeLevelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
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
		Assert.notNull(employeeLevel.getId(), "职位编号不能为空.");

		EmployeeLevel tempEmployeeLevel = findOne(employeeLevel.getId());
		Assert.notNull(tempEmployeeLevel, "职位信息不存在.修改失败..");

		BeanUtils.copyProperties(employeeLevel, tempEmployeeLevel);

		employeeLevel = repository.save(tempEmployeeLevel);
		return !ObjectUtils.isEmpty(employeeLevel) && !StringUtils.isEmpty(employeeLevel.getId());
	}

	@Override
	public EmployeeLevel findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<EmployeeLevel> findByNameLike(String name) {
		return repository.findByNameLike("%" + name + "%");
	}

	@Override
	public Page<EmployeeLevel> pageAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
