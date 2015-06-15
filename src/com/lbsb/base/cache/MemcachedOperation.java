package com.lbsb.base.cache;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
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

	@Autowired
	private SerializingTranscoder serializingTranscoder;

	private static final int singleTimeout = 1500;

	private static final int multipleTimeout = 3000;

	private static final int exp = 10;

	public boolean add(String key, Object value) throws InterruptedException,
			TimeoutException, ExecutionException {
		return add(key, exp, value);
	}

	public boolean add(String key, int exp, Object value)
			throws InterruptedException, TimeoutException, ExecutionException {
		OperationFuture<Boolean> future = memcachedClient.add(key, exp, value,
				serializingTranscoder);
		try {
			return future.get(singleTimeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw e;
		} catch (ExecutionException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean set(String key, Object value) throws InterruptedException,
			TimeoutException, ExecutionException {
		return set(key, exp, value);
	}

	public boolean set(String key, int exp, Object value)
			throws InterruptedException, TimeoutException, ExecutionException {
		OperationFuture<Boolean> future = memcachedClient.set(key, exp, value,
				serializingTranscoder);
		try {
			return future.get(singleTimeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw e;
		} catch (ExecutionException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Object get(String key) {
		Future<Object> future = memcachedClient.asyncGet(key,
				serializingTranscoder);
		try {
			return future.get(singleTimeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			future.cancel(false);
		} catch (ExecutionException e) {
			e.printStackTrace();
			future.cancel(false);
		} catch (TimeoutException e) {
			e.printStackTrace();
			future.cancel(false);
		}
		return null;
	}

	public Map<String, Object> getMuti(List<String> keyList) {
		Future<Map<String, Object>> future = memcachedClient.asyncGetBulk(
				keyList, serializingTranscoder);
		try {
			return future.get(multipleTimeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			future.cancel(false);
		} catch (ExecutionException e) {
			e.printStackTrace();
			future.cancel(false);
		} catch (TimeoutException e) {
			e.printStackTrace();
			future.cancel(false);
		}
		return Collections.<String, Object> emptyMap();
	}

	public void delete(String key) {
		memcachedClient.delete(key);
	}

	public void clear() {
		memcachedClient.flush();
	}

	public long incr(String key, int by) {
		return memcachedClient.incr(key, by, 0);
	}

	public long incr(String key, int by, long def) {
		return memcachedClient.incr(key, by, def);
	}

	public long incr(String key, int by, long def, int exp) {
		return memcachedClient.incr(key, by, def, exp);
	}

	public long incr(String key, long by) {
		return memcachedClient.incr(key, by, 0);
	}

	public long incr(String key, long by, long def) {
		return memcachedClient.incr(key, by, def);
	}

	public long incr(String key, long by, long def, int exp) {
		return memcachedClient.incr(key, by, def, exp);
	}

	public long decr(String key, int by) {
		return memcachedClient.decr(key, by, 0);
	}

	public long decr(String key, int by, long def) {
		return memcachedClient.decr(key, by, def);
	}

	public long decr(String key, int by, long def, int exp) {
		return memcachedClient.decr(key, by, def, exp);
	}

	public long decr(String key, long by, long def) {
		return memcachedClient.decr(key, by, 0);
	}

	public long decr(String key, long by, long def, int exp) {
		return memcachedClient.decr(key, by, def, exp);
	}

	public boolean replace(String key, int exp, Object value) throws InterruptedException, ExecutionException, TimeoutException {
		Future<Boolean> future = memcachedClient.replace(key, exp, value, serializingTranscoder);
		try {
			return future.get(singleTimeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw e;
		} catch (ExecutionException e) {
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
