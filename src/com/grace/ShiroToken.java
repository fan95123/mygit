package com.grace;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

public class ShiroToken extends AuthenticatingRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken uptoken = (UsernamePasswordToken)token;
		String username = uptoken.getUsername();
		if("abc".equals(username)) {
			throw new UnknownAccountException("用户名不存在。。");
		}
		if("aaa".equals(username)) {
			throw new LockedAccountException("用户被锁定");
		}
		Object principal = username;
		String credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
		String realmName = getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		return info;
	}



}
