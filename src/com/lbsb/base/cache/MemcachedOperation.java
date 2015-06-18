package com.lbsb.base.cache;


/**
 * 
 * @author Hunter
 * @createDate June 12th,2015
 * 
 */
public interface MemcachedOperation extends CacheOperation {

	public long incr(String key, int by, long def);
	
	public long incr(String key, int by, long def, int exp);
	
	public long incr(String key, long by, long def);
	
	public long incr(String key, long by, long def, int exp);
	
	public long decr(String key, int by, long def);
	
	public long decr(String key, int by, long def, int exp);
	
	public long decr(String key, long by, long def);
	
	public long decr(String key, long by, long def, int exp);

}
