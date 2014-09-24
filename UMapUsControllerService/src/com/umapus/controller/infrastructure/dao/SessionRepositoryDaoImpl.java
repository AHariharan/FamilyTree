package com.umapus.controller.infrastructure.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.umapus.common.domain.entity.UMapUsConstants;
import com.umapus.controller.domain.util.UMapUsMapper;

public class SessionRepositoryDaoImpl implements SessionRepositoryDao {

	@Autowired
	private UMapUsMapper umapusmapper;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private HashOperations<String, Object, Object> hashOps;

	public void addToRedis(String key, HashMap<String, String> hashvalue) {
       
		redisTemplate.opsForHash().putAll(key, hashvalue);
		
		redisTemplate.expire(key, UMapUsConstants.RedisKeyTTLInHrs,
				TimeUnit.HOURS);

	}

	public HashMap<String, String> readFromRedis(String key) {

		BoundHashOperations<String, String, String> userOps = redisTemplate
				.boundHashOps(key);
		// System.out.println("Redis keys=" + userOps.entries());

		return (HashMap<String, String>) userOps.entries();
	}

	public void updateToRedis(String key, HashMap<String, String> hashValue) {
		BoundHashOperations<String, String, String> userOps = redisTemplate
				.boundHashOps(key);
		Map<String, String> hm = (HashMap<String, String>) userOps.entries();
		for (Map.Entry<String, String> entry : hashValue.entrySet()) {

			hm.put(entry.getKey(), entry.getValue());
		}
		redisTemplate.opsForHash().putAll(key, hm);
	}

	public void deleteFromRedis(String key) {

		redisTemplate.delete(key);
	}
}
