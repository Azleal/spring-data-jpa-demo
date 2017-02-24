package com.keveon.model.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * Created by Keveon on 2017/2/24.
 * 部门信息
 */
@Data
@RequiredArgsConstructor
public class DeptVo implements Serializable {
	private static final long serialVersionUID = -8459755922288527580L;

	/**
	 * 部门编号
	 */
	Integer id;

	/**
	 * 部门名称
	 */
	String name;
}
