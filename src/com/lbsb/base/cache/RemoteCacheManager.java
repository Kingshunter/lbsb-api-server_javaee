package com.lbsb.base.cache;

import java.util.List;
import java.util.Map;

/**
 * 缓存管理
 * @author Hunter
 * @createDate June 17th,2015
 *
 */
public class RemoteCacheManager {
	
	private CacheOperation cacheOperation;
	
	public CacheOperation getCacheOperation() {
		return cacheOperation;
	}

	public void setCacheOperation(CacheOperation cacheOperation) {
		this.cacheOperation = cacheOperation;
	}

	private RemoteCacheManager() {
		
	}
	
	public static RemoteCacheManager getInstance() {
		return SingletonRemoteCacheManager.cacheManager;
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
	
	private static class SingletonRemoteCacheManager {
		private static final RemoteCacheManager cacheManager = new RemoteCacheManager();
	}
}
