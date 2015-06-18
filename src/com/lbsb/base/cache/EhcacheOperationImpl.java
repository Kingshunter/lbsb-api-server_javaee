package com.lbsb.base.cache;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import com.lbsb.exceptions.CacheException;
import com.lbsb.utils.TimeUtil;

public class EhcacheOperationImpl implements EhcacheOperation {

	private EhcacheClient ehcacheClient;

	private static final int exp = 10;

	private static ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<String, AtomicInteger>();

	public boolean add(String key, Object value, String expiration) {
		try {
			checkSerializable(value);
			return add(key, TimeUtil.parseDuration(expiration), value);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean set(String key, Object value, String expiration) {
		try {
			checkSerializable(value);
			return set(key, TimeUtil.parseDuration(expiration), value);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean replace(String key, Object value, String expiration) {
		try {
			checkSerializable(value);
			return replace(key, TimeUtil.parseDuration(expiration), value);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean add(String key, Object value) throws Exception {
		return add(key, exp, value);
	}

	public boolean add(String key, int exp, Object value) throws Exception {
		AtomicInteger atomicInteger = null;
		Cache cache = ehcacheClient.cache;
		if (cache.get(key) != null)
			return false;

		if (map.contains(key)) {
			atomicInteger = map.get(key);
			int count = atomicInteger.getAndIncrement();
			if (count == 1) {
				Element element = new Element(key, value);
				element.setTimeToLive(exp);
				cache.put(element);
				map.remove(key);
				return true;
			}
		} else {
			atomicInteger = new AtomicInteger(0);
			map.put(key, atomicInteger);
			return false;
		}
		return false;
	}

	public boolean set(String key, Object value) throws Exception {
		return set(key, exp, value);
	}

	public boolean set(String key, int exp, Object value) throws Exception {
		try {
			Cache cache = ehcacheClient.cache;
			Element element = new Element(key, value);
			element.setTimeToLive(exp);
			cache.put(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Object get(String key) {
		Cache cache = ehcacheClient.cache;
		Element e = cache.get(key);
		if (e == null)
			return null;
		return e;
	}

	public Map<String, Object> getMuti(List<String> keyList) {
		int keyListSize = keyList.size();
		Map<String, Object> map = new HashMap<String, Object>(keyListSize);
		String key = null;
		for (int i = 0; i < keyListSize; i++) {
			key = keyList.get(i);
			map.put(key, get(key));
		}
		return map;
	}

	public void delete(String key) {
		Cache cache = ehcacheClient.cache;
		cache.remove(key);
	}

	public void clear() {
		Cache cache = ehcacheClient.cache;
		cache.removeAll();
	}

	public long incr(String key, int by) {
		Cache cache = ehcacheClient.cache;
		Element e = cache.get(key);
		if (e == null) {
			return -1;
		}
		long newValue = ((Number) e.getObjectValue()).longValue() + by;
		Element newE = new Element(key, newValue);
		newE.setTimeToLive(e.getTimeToLive());
		cache.put(newE);
		return newValue;
	}

	public long incr(String key, long by) {
		Cache cache = ehcacheClient.cache;
		Element e = cache.get(key);
		if (e == null) {
			return -1;
		}
		long newValue = ((Number) e.getObjectValue()).longValue() + by;
		Element newE = new Element(key, newValue);
		newE.setTimeToLive(e.getTimeToLive());
		cache.put(newE);
		return newValue;
	}

	public long decr(String key, int by) {
		Cache cache = ehcacheClient.cache;
		Element e = cache.get(key);
		if (e == null) {
			return -1;
		}
		long newValue = ((Number) e.getObjectValue()).longValue() - by;
		Element newE = new Element(key, newValue);
		newE.setTimeToLive(e.getTimeToLive());
		cache.put(newE);
		return newValue;
	}

	public long decr(String key, long by) {
		Cache cache = ehcacheClient.cache;
		Element e = cache.get(key);
		if (e == null) {
			return -1;
		}
		long newValue = ((Number) e.getObjectValue()).longValue() - by;
		Element newE = new Element(key, newValue);
		newE.setTimeToLive(e.getTimeToLive());
		cache.put(newE);
		return newValue;
	}

	public boolean replace(String key, int exp, Object value) throws Exception {
		Cache cache = ehcacheClient.cache;
		if (cache.get(key) == null) {
			return false;
		}

		try {
			Element element = new Element(key, value);
			element.setTimeToLive(exp);
			cache.put(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void checkSerializable(Object value) {
		if (value != null && !(value instanceof Serializable)) {
			throw new CacheException(
					"Cannot cache a non-serializable value of type "
							+ value.getClass().getName(),
					new NotSerializableException(value.getClass().getName()));
		}
	}

	public EhcacheClient getEhcacheClient() {
		return ehcacheClient;
	}

	public void setEhcacheClient(EhcacheClient ehcacheClient) {
		this.ehcacheClient = ehcacheClient;
	}

}
