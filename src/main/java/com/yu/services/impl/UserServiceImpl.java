package com.yu.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yu.common.MainConstants;
import com.yu.common.Validator;
import com.yu.dao.idao.UserMapper;
import com.yu.entity.User;
import com.yu.services.inter.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private Validator vd;
	
	
	public User find(int userId) throws Exception{
		
		return userMapper.selectByPrimaryKey(userId);
	}
	
	public User find(String userName) throws Exception{
		return vd.isBlank(userName)?null:userMapper.selectByName(userName);
	}


	@Override
	public Map<String, Object> addUser(User user) throws Exception{
		return null;
	}

	@Override
	public Map<String, Object> updateUser(User user)throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 验证用户名和密码
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Map<String,Object> checkUser(User user) throws Exception{
		Map<String,Object> map = new HashMap<>();
		Map<String,List<String>> checkResult = new HashMap<>();
		checkResult = vd.checkObject(user);
		if(checkResult.size()>0){
			map.put(MainConstants.MSG, checkResult);
		}
		map.put(MainConstants.STATUS, MainConstants.FALSE);
		User userDao = userMapper.selectByName(user.getUserName());
		if(userDao!=null){
			if(user.getUserPassword().equals(userDao.getUserPassword())){
				map.put(MainConstants.STATUS, MainConstants.TRUE);
				map.put(MainConstants.MSG, MainConstants.LOGIN_SUCCESS);
				map.put("user", userDao);
				return map;
			}
		}
		map.put(MainConstants.MSG, MainConstants.INCORRECT_PASS);
		return map;
	}
	
	
}
