package com.keveon.repository;

import com.keveon.model.Dept;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Keveon on 2017/2/14.
 * 部门dao
 */
public interface DeptRepository extends CrudRepository<Dept, Integer> {
    /**
     * 通过部门名称关键字模糊查询部门信息
     *
     * @param name 部门名称关键字
     * @return 符合条件的部门的信息
     */
    List<Dept> findByNameLike(String name);
}
