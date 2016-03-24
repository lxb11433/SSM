package com.cn.alex.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.alex.model.User;
import com.cn.alex.service.IUserService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
	@Autowired  
    private IUserService userService;  
    protected final Logger logger = LogManager.getLogger(UserController.class.getName());
    
    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
    }  
}  