package com.keveon.repository;

import com.keveon.model.EmployeeLevel;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Keveon on 2017/2/14.
 * 职位仓库
 */
public interface EmployeeLevelRepository extends PagingAndSortingRepository<EmployeeLevel, Integer> {
    /**
     * 通过职位名称关键字模糊查询职位信息
     *
     * @param name 职位名称关键字
     * @return 符合条件的职位的信息
     */
    List<EmployeeLevel> findByNameLike(String name);
}
