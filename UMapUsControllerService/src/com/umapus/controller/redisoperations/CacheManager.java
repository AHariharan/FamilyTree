package com.umapus.controller.redisoperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class CacheManager {
	
	@Autowired
	RedisTemplate<String, String> activationTemplate;
	
	public void addActivationLink(String key,String hashedURI)
	{
		this.activationTemplate.opsForHash().put(key, key.hashCode(), hashedURI);		
	}
	
	public String getActivationLinkValue(String key)
	{
		return (String) this.activationTemplate.opsForHash().get(key, key.hashCode());
	}
	
	public void removeActivationLinkKey(String key)
	{
		this.activationTemplate.delete(key);
	}
	

}
