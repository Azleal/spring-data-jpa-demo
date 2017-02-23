package com.keveon.rest;

import com.keveon.model.Dept;
import com.keveon.service.DeptService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Keveon on 2017/2/23.
 * Dept rest api interface
 */
@RestController
@RequestMapping("/departments")
public class DeptController {

	private final DeptService service;

	@Autowired
	public DeptController(DeptService service) {
		this.service = service;
	}

	@ApiOperation(value = "获取部门信息", notes = "通过部门id获取部门信息")
	@ApiImplicitParam(name = "id", value = "部门编号", required = true, dataType = "Integer", paramType = "path")
	@GetMapping("/{id}")
	public Dept getUserList(@PathVariable String id) {
		Dept dept = service.findOne(Integer.valueOf(id));
		dept.setEmployees(null);
		return dept;
	}
}
