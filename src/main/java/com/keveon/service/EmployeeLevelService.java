package com.keveon.service;

import com.keveon.model.EmployeeLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Keveon on 2017/2/14.
 * 职位信息逻辑
 */
public interface EmployeeLevelService {
	/**
	 * 新增职位
	 *
	 * @param employeeLevel 职位信息
	 * @return 新增结果
	 */
	Boolean create(EmployeeLevel employeeLevel);

	/**
	 * 通过职位编号删除职位信息
	 *
	 * @param id 职位信息编号
	 */
	void remove(Integer id);

	/**
	 * 删除职位信息
	 *
	 * @param employeeLevel 职位信息
	 */
	void remove(EmployeeLevel employeeLevel);

	/**
	 * 更新职位
	 *
	 * @param employeeLevel 职位信息
	 * @return 更新结果
	 */
	Boolean update(EmployeeLevel employeeLevel);

	/**
	 * 通过职位编号查询职位信息
	 *
	 * @param id 职位编号
	 * @return 职位信息
	 */
	EmployeeLevel findOne(Integer id);

	/**
	 * 通过职位名称关键字模糊查询职位信息
	 *
	 * @param name 职位名称关键字
	 * @return 符合条件的职位的信息
	 */
	List<EmployeeLevel> findByNameLike(String name);

    /**
     * 查询全部职位信息并分页
     *
     * @return 分页后的职位信息
     */
    Page<EmployeeLevel> pageAll(Pageable pageable);
}
