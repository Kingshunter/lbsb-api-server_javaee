package com.lbsb.base.cache;

import java.util.List;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.transcoders.SerializingTranscoder;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Hunter
 * @createDate June 12th,2015
 *
 */
public class MemcachedOperation implements CacheOperation {

	@Autowired
	private MemcachedClient memcachedClient;
	
	private SerializingTranscoder serializingTranscoder;
	
	private static final int exp = 10;
	
	public boolean add(String key, Object value) {
		
		return add(key, value, exp);
	}

	public boolean add(String key, Object value, int exp) {
		Future<?> future = memcachedClient.add(key, exp, value, serializingTranscoder);
		return false;
	}

	public boolean set(String key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean set(String key, Object value, int exp) {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> T get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> getMuti(List<String> keyList) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public long incr(String key, int by) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long incr(String key, int by, long def) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long incr(String key, int by, long def, int exp) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long incr(String key, long by) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long incr(String key, long by, long def) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long incr(String key, long by, long def, int exp) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long decr(String key, int by) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long decr(String key, int by, long def) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long decr(String key, int by, long def, int exp) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long decr(String key, long by, long def) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long decr(String key, long by, long def, int exp) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean replace(String key, Object value, int exp) {
		// TODO Auto-generated method stub
		return false;
	}

}
