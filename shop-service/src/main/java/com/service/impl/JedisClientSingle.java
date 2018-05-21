package com.service.impl;

import com.service.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientSingle implements JedisClient {
	@Autowired
	private JedisPool jedisPool;
	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.set(key, value);
		jedis.close();
		return string;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		long long1 = jedis.hset(hkey, key, value);
		jedis.close();
		return long1;
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.hget(hkey, key);
		jedis.close();
		return string;
	}

	@Override
	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		long long1 = jedis.incr(key);
		jedis.close();
		return long1;
	}

	@Override
	public long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		long long1 = jedis.expire(key, second);
		jedis.close();
		return long1;
	}

	@Override
	public long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		long long1 = jedis.ttl(key);
		jedis.close();
		return long1;
	}

}
