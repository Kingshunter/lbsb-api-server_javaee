package com.lbsb.base.cache;

import java.util.List;
import java.util.Map;

public class CacheManager {
	
	private CacheOperation cacheOperation;
	
	public CacheOperation getCacheOperation() {
		return cacheOperation;
	}

	public void setCacheOperation(CacheOperation cacheOperation) {
		this.cacheOperation = cacheOperation;
	}

	private CacheManager() {
		
	}
	
	public static CacheManager getInstance() {
		return SingletonCacheOperation.cacheManager;
	}
	
	
	
	public static void init() {
		getInstance();
	}
	
	
	public boolean add(String key, Object value) {
		try {
			return cacheOperation.add(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean add(String key, int exp, Object value) {
		try {
			return cacheOperation.add(key, exp, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean set(String key, Object value) {
		try {
			return cacheOperation.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean set(String key, int exp, Object value) {
		try {
			return cacheOperation.set(key, exp, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Object get(String key) {
		try {
			return cacheOperation.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Map<String, Object> getMulti(List<String> keyList) {
		return cacheOperation.getMuti(keyList);
	}
	
	private static class SingletonCacheOperation {
		private static final CacheManager cacheManager = new CacheManager();
	}
}
