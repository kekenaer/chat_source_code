package com.yu.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 长度注解
 * 参数1：最大长度
 * 参数2：最小长度
 * @author YuPeng
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
	
	public int max();
	
	public int min();
}
