package com.keveon.model.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * Created by Keveon on 2017/2/24.
 * 职位
 */
@Data
@RequiredArgsConstructor
public class EmployeeLevelVo implements Serializable {
	private static final long serialVersionUID = 39445974064595266L;

	/**
	 * 编号
	 */
	Integer id;

	/**
	 * 职位名称
	 */
	String name;
}
