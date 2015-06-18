package com.lbsb.base.cache;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Hunter
 * @createDate June 12th,2015
 *
 */
public interface CacheOperation {
	
	public boolean add(String key, Object value) throws Exception;
	
	public boolean add(String key, int exp, Object value) throws Exception;
	
	public boolean set(String key, Object value) throws Exception;
	
	public boolean set(String key, int exp, Object value) throws Exception;
	
	public Object get(String key);
	
	public Map<String, Object> getMuti(List<String> keyList);
	
	public void delete(String key);
	
	public void clear();
	
	public long incr(String key, int by);
	
	public long incr(String key, long by);
	
	public long decr(String key, int by);
	
	public long decr(String key, long by);
	
	public boolean replace(String key, int exp, Object value) throws Exception;
}
