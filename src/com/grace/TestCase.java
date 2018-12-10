package com.grace;

import org.apache.shiro.crypto.hash.SimpleHash;

public class TestCase {
	public static void main(String[] args) {
		String algorithmName = "MD5";
		String source = "123456";
		String salt = null;
		int hashIterations = 1024;
		SimpleHash hash = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(hash);
	}
}
