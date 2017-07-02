package com.yu.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yu.common.MainConstants;
import com.yu.controller.BaseController;
import com.yu.entity.User;
import com.yu.services.inter.UserService;

@Controller
@RequestMapping("/user")
public class UserLoginController extends BaseController {
	@Autowired
	private UserService us;
	
	@RequestMapping("login")
	public String toLogin(){
		return "login/login";
	}
	
	@RequestMapping("login/check")
	@ResponseBody
	public Map<String,Object> login(User user,HttpServletRequest req,HttpServletResponse rsp){
		logger.info("用户"+user.getUserName()+"登陆开始");
		Map<String,Object> map = new HashMap<>();
		try {
			map = us.checkUser(user);
			if((Boolean)map.get("status")==true){
				HttpSession session = req.getSession(true);
				session.setAttribute("user", map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(MainConstants.LOGIN_ERR,e);
		}
		logger.info("用户"+user.getUserName()+"登陆结束");
		return map;
	}
	
	
}
