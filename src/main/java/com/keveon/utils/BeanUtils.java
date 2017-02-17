package com.keveon.utils;

import lombok.experimental.UtilityClass;
import org.springframework.util.Assert;

import java.lang.reflect.Field;

import static java.util.Objects.isNull;

/**
 * Created by Keveon on 2017/2/17.
 * Bean工具
 */
@UtilityClass
public class BeanUtils {

	/**
	 * 复制一个对象的值到另一个对象, 两个对象的类型相同
	 * 若
	 *
	 * @param formEntity 要复制值的对象
	 * @param toEntity   要复制值给的对象
	 */
	public <T> void copyTo(T formEntity, T toEntity) {

		Assert.notNull(formEntity, "formEntity不能为空");
		Assert.notNull(toEntity, "toEntity不能为空");

		// 通过反射获取Bean中所有定义的字段
		Field[] fields = formEntity.getClass().getDeclaredFields();
		for (Field field : fields) {

			// 如果是序列化UID则忽略
			if ("serialVersionUID".equalsIgnoreCase(field.getName()))
				continue;

			// 读取当前遍历到的栏位默认访问权限
			boolean isAccess = field.isAccessible();
			// 设置为可读写
			field.setAccessible(true);

			try {

				// 读取当前字段的值
				Object fieldValue = field.get(formEntity);

				// 如果不为空, 赋值给toEntity对象
				if (!isNull(fieldValue)) {
					field.set(toEntity, fieldValue);
				}

				// 恢复之前的权限
				field.setAccessible(isAccess);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
