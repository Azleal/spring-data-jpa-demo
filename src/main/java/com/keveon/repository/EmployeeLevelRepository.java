package com.keveon.repository;

import com.keveon.model.EmployeeLevel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Keveon on 2017/2/14.
 * 职位仓库
 */
public interface EmployeeLevelRepository extends CrudRepository<EmployeeLevel, Integer> {
}
