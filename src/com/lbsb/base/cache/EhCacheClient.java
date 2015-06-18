package com.lbsb.base.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

/**
 * 
 * @author Hunter
 * @createDate June 17th,2015
 *
 */
public class EhcacheClient {
	
	private CacheManager cacheManager;

    Cache cache;
    
    private static final String ehcacheName = "lbsb";
	
	private EhcacheClient() {
		cacheManager = CacheManager.create();
		cacheManager.addCache(ehcacheName);
		cache = cacheManager.getCache(ehcacheName);
	}
	
}
