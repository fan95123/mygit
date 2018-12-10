package com.grace;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {
	
	
	@RequestMapping("abc")
	public String Shiros(@RequestParam("name") String name,@RequestParam("pwd") String pwd) {
	       Subject currentUser = SecurityUtils.getSubject();
	        if (!currentUser.isAuthenticated()) {
	            UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
	            token.setRememberMe(true);
	            try {
	                currentUser.login(token);
	            }catch (AuthenticationException ae) {
	            	System.out.println("µÇÂ½Ê§°Ü¡£¡£¡£"+ae.getMessage());
	            }
	        }
		
		
		
//		Subject subject = SecurityUtils.getSubject();
//		if(!subject.isAuthenticated()) {
//			UsernamePasswordToken token = new UsernamePasswordToken(name,pwd);
//			token.setRememberMe(true);
//			try {
//				System.out.println(token.hashCode());
//				subject.login(token);
//			}catch(AuthenticationException e) {
//				System.out.println("µÇÂ½Ê§°Ü¡£¡£¡£"+e.getMessage());
//				return "index";
//			}
//		}
		
		
		return "success";
	}
}
