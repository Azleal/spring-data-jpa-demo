package com.keveon.rest;

import com.keveon.model.Dept;
import com.keveon.model.vo.DeptVo;
import com.keveon.service.DeptService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

	@ApiOperation(value = "新增部门信息", notes = "根据dept对象创建部门信息")
	@ApiImplicitParam(name = "dept", value = "部门信息", required = true, dataType = "DeptVo", paramType = "body")
	@PostMapping
	public Boolean save(@RequestBody Dept dept) {
		return service.save(dept);
	}

	@ApiOperation(value = "删除部门信息", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "部门编号", required = true, dataType = "Integer", paramType = "path")
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@ApiOperation(value = "更新部门信息", notes = "根据url的id来指定更新对象，并根据传过来的dept信息来更新部门详细信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "部门编号", required = true, dataType = "Integer", paramType = "path"),
			@ApiImplicitParam(name = "dept", value = "部门信息", required = true, dataType = "DeptVo", paramType = "body")
	})
	@PatchMapping("{id}")
	public Boolean update(@PathVariable Integer id, @RequestBody Dept dept) {
		return service.update(id, dept);
	}

	@ApiOperation(value = "获取部门信息", notes = "通过部门id获取部门信息")
	@ApiImplicitParam(name = "id", value = "部门编号", required = true, dataType = "Integer", paramType = "path")
	@GetMapping("/{id}")
	public DeptVo getUserList(@PathVariable String id) {
		Dept dept = service.findOne(Integer.valueOf(id));
		DeptVo deptVo = new DeptVo();
		BeanUtils.copyProperties(dept, deptVo);
		return deptVo;
	}

	@ApiOperation(value = "获取部门信息", notes = "通过部门名称的关键字", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiImplicitParam(name = "deptNameKeyword", value = "部门名称关键字", required = true, dataType = "String", paramType = "query")
	@GetMapping("")
	public List<DeptVo> findByNameLike(@RequestParam("deptNameKeyword") String name) {
		List<Dept> list = service.findByNameLike(name);
		List<DeptVo> voList = new ArrayList<>();

		for (Dept dept : list) {
			DeptVo vo = new DeptVo();
			BeanUtils.copyProperties(dept, vo);
			voList.add(vo);
		}

		return voList;
	}
}
