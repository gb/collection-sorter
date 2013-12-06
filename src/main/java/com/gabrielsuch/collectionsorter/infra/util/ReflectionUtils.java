package com.gabrielsuch.collectionsorter.infra.util;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;

public class ReflectionUtils {
	
	private ReflectionUtils() { }

	public static boolean classContainsGetter(Class<?> clazz, String fieldName) {
		Method[] methodList = clazz.getDeclaredMethods();
		
		for (Method method : methodList) 
			 if (isGetterToField(method, fieldName)) return true;

		return false;
	}

	private static boolean isGetterToField(Method method, String fieldName) {
		return method.getName().equals(getterName(fieldName));
	}
	
	private static String getterName(String fieldName) {
		return "get" + StringUtils.capitalize(fieldName);
	}

}
