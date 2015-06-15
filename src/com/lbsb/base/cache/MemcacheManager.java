package com.lbsb.base.cache;

import org.springframework.beans.factory.annotation.Autowired;

public class MemcacheManager {
	
	@Autowired
	private CacheOperation memcahOperation;
	
	private MemcacheManager() {
		
	}
	
	public static MemcacheManager getInstance() {
		return SingletonMemcachedOperation.memcacheManager;
	}
	
	
	
	public static void init() {
		getInstance();
	}
	
	
	
	private static class SingletonMemcachedOperation {
		private static final MemcacheManager memcacheManager = new MemcacheManager();
	}
}
