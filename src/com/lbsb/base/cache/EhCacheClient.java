package com.lbsb.base.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

/**
 * 
 * @author Hunter
 * @createDate June 17th,2015
 *
 */
public class EhCacheClient {
	
	private static EhCacheClient ehCacheClient;
	
	private CacheManager cacheManager;

    Cache cache;
    
    private static final String ehcacheName = "lbsb";
	
	private EhCacheClient() {
		cacheManager = CacheManager.create();
		cacheManager.addCache(ehcacheName);
		cache = cacheManager.getCache(ehcacheName);
	}
	
	public static EhCacheClient getInstance() {
		return ehCacheClient;
	}
	
	public static void init() {
		ehCacheClient = SingletonEhCacheClient.ehCacheClient;
		
	}
	
	private static class SingletonEhCacheClient {
		private static final EhCacheClient ehCacheClient = new EhCacheClient();
	}	
	
}
