package com.lbsb.base.cache;


/**
 * 
 * @author Hunter
 * @createDate June 17th,2015
 * 
 */
public interface EhcacheOperation extends CacheOperation {

	public boolean add(String key, Object value, String expiration);
	
    public boolean set(String key, Object value, String expiration);
    
    public boolean replace(String key, Object value, String expiration);
    
}
