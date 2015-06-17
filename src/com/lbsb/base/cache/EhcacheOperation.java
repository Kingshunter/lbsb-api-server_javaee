package com.lbsb.base.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import net.sf.ehcache.Cache;

/**
 * 
 * @author Hunter
 * @createDate June 17th,2015
 *
 */
public class EhcacheOperation implements CacheOperation {

	private EhCacheClient ehCacheClient;
	
	public boolean add(String key, Object value) throws InterruptedException,
			TimeoutException, ExecutionException {
		Cache cache = ehCacheClient.cache;
		
		return false;
	}

	public boolean add(String key, int exp, Object value)
			throws InterruptedException, TimeoutException, ExecutionException {
		return false;
	}

	public boolean set(String key, Object value) throws InterruptedException,
			TimeoutException, ExecutionException {
		return false;
	}

	public boolean set(String key, int exp, Object value)
			throws InterruptedException, TimeoutException, ExecutionException {
		return false;
	}

	public Object get(String key) {
		return null;
	}

	public Map<String, Object> getMuti(List<String> keyList) {
		return null;
	}

	public void delete(String key) {

	}

	public void clear() {

	}

	public long incr(String key, int by) {
		return 0;
	}

	public long incr(String key, int by, long def) {
		return 0;
	}

	public long incr(String key, int by, long def, int exp) {
		return 0;
	}

	public long incr(String key, long by) {
		return 0;
	}

	public long incr(String key, long by, long def) {
		return 0;
	}

	public long incr(String key, long by, long def, int exp) {
		return 0;
	}

	public long decr(String key, int by) {
		return 0;
	}

	public long decr(String key, int by, long def) {
		return 0;
	}

	public long decr(String key, int by, long def, int exp) {
		return 0;
	}

	public long decr(String key, long by, long def) {
		return 0;
	}

	public long decr(String key, long by, long def, int exp) {
		return 0;
	}

	public boolean replace(String key, int exp, Object value)
			throws InterruptedException, ExecutionException, TimeoutException {
		return false;
	}

	public EhCacheClient getEhCacheClient() {
		return ehCacheClient;
	}

	public void setEhCacheClient(EhCacheClient ehCacheClient) {
		this.ehCacheClient = ehCacheClient;
	}
}
