package com.lbsb.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lbsb.base.cache.MemcachedOperation;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("/resource/framework/applicationContext-cache.xml");
		MemcachedOperation cacheOperation = (MemcachedOperation) ctx.getBean("memcachedOperation");
		System.out.println(cacheOperation);
	}
}
