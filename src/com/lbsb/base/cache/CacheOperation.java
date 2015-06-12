package com.lbsb.base.cache;

import java.util.List;

/**
 * 
 * @author KingsHunter
 * @createDate June 12th,2015
 *
 */
public interface CacheOperation {
	
	public boolean add(String key, Object value);
	
	public boolean add(String key, Object value, int exp);
	
	public boolean set(String key, Object value);
	
	public boolean set(String key, Object value, int exp);
	
	public <T> T get(String key);
	
	public <T> List<T> getMuti(List<String> keyList);
	
	public void delete(String key);
	
	public void clear();
	
	public long incr(String key, int by);
	
	public long incr(String key, int by, long def);
	
	public long incr(String key, int by, long def, int exp);
	
	public long incr(String key, long by);
	
	public long incr(String key, long by, long def);
	
	public long incr(String key, long by, long def, int exp);
	
	public long decr(String key, int by);
	
	public long decr(String key, int by, long def);
	
	public long decr(String key, int by, long def, int exp);
	
	public long decr(String key, long by, long def);
	
	public long decr(String key, long by, long def, int exp);
	
	public boolean replace(String key, Object value, int exp);
}
