package com.yu.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.yu.common.annotation.BackMsg;
import com.yu.common.annotation.Length;
import com.yu.common.annotation.NotNull;
import com.yu.common.annotation.Range;
import com.yu.common.annotation.Regex;
import com.yu.common.exceptions.ParamException;

@Component
public class Validator {
	
	private Logger logger = Logger.getLogger(Validator.class);
	/**
	 * 对字符串类型参数进行判空
	 * @param str
	 * @return
	 */
	public boolean isBlank(String str){
		
		if(str==null && "".equals(str.trim())){
			return true;
		}
		return false;
	}
	/**
	 * 对字符串进行正则验证
	 * @param target
	 * @param regx
	 * @return
	 */
	public boolean checkWithRegx(String target,String regx)throws ParamException{
		if(isBlank(target) || isBlank(regx)){
			throw new ParamException(MainConstants.PARAM_NOT_NULL);
		}
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(target);
		return matcher.matches();
	}
	/**
	 * 对象注解方式校验对象参数是否符合要求
	 * @param obj
	 * @return Map<String,List<String>> 返回map对象，key为对象属性名，value：包含反馈信息的list集合
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ParamException
	 */
	public Map<String,List<String>> checkObject(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParamException{
		logger.info("---------------校验开始-----------------");
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		if(obj!=null){
			Class<? extends Object>  clazz = obj.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for(Field f:fields){
				//获取属性名
				String fname = f.getName();
				logger.info("---------------正在校验"+fname+"属性-----------------");
				NotNull notNull = f.getAnnotation(NotNull.class);
				Range range = f.getAnnotation(Range.class);
				Regex regex = f.getAnnotation(Regex.class);
				Length length = f.getAnnotation(Length.class);
				BackMsg msg = f.getAnnotation(BackMsg.class);
				//如果属性没有注解则继续循环
				if(notNull==null && range==null 
						&& regex==null && length==null){
					logger.info("---------------"+fname+"不需要校验！-----------------");
					continue;
				}
				//获取注解的反馈信息
				String message = msg!=null?msg.msg():"";
				
				List<String> types = new ArrayList<String>();
				//获取属性的Get方法
				Method method=null;
				method = clazz.getMethod("get"+firstLetterToUpperCase(fname));
				//获取属性值
				Object value = method.invoke(obj);
				if(notNull!=null && value==null){
					types.add(message);
				}
				if(range!=null){
					double max = range.max();
					double min = range.min();
					if((Double)value > max || (Double)value<min){
						types.add(message);
					}
				}
				if(regex!=null){
					String regexStr = regex.regexString();
					if(!checkWithRegx((String)value,regexStr)){
						types.add(message);
					}
				}
				if(length!=null){
					int max = length.max();
					int min = length.min();
					int strLength = ((String) value).length();
					if(max>min){
						if(strLength>max || strLength<min){
							types.add(message);
						}
					}else if(max==min){
						if(strLength != max){
							types.add(message);
						}
					}else{
						throw new ParamException(MainConstants.PARAM_ERR);
					}
				}
				if(types.size()>0){
					map.put(fname, types);
				}
				
				logger.info("---------------校验"+fname+"属性结束-----------------");
			}
		}
		logger.info("---------------checkObject校验结束-----------------");
		return map;
	}
	
	
	public String firstLetterToUpperCase(String str){
		if(!isBlank(str)){
			char c = Character.toUpperCase(str.charAt(0));
			str = c+str.substring(1, str.length());
			return str;
		}
		return null;
		
	}
	
	/**
	 * 将字符串中的特殊符号进行转译
	 * @param str
	 * @return
	 */
	public String formatString(String str){
		
		if(!isBlank(str)){
			str.replace("<", "&lt");
			str.replace(">", "&gt");
			str.replace("&", "&amp");
			System.out.println("替换成功！"+str);
			return str;
		}
		
		return null;
	}
	
//	public static void main(String[] args) {
//		Validator v = new Validator();
//		Address address = new Address();
//		address.setAddress("");
//		address.setAddrPhone("15023351428");
//		address.setReceiver("dfadfdsafsadfsadf");
//		address.setAddrTel("023-5351");
//		try {
//			long time1 = System.currentTimeMillis();
//			Map<String,List<String>> map = v.checkObject(address);
//			long time2 = System.currentTimeMillis();
//			System.out.println("使用时间："+(time2-time1));
//			if(map.size()>0){
//				for (Entry<String, List<String>> entry : map.entrySet()) {
//					List<String> list = (List)(entry.getValue());
//					if(list.size()>0){
//						for(String arg:list){
//							 System.out.println("Key = " + entry.getKey() + ", Value = " + arg); 
//						}
//					}
//					
//				}  
//			}else{
//				System.out.println("恭喜您！校验通过了！");
//			}
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParamException e) {
//			System.out.println(e.getMsg());
//			e.printStackTrace();
//		}
//		
//	}
}
