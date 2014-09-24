package com.umapus.controller.infrastructure.dao;

import java.util.HashMap;

public interface SessionRepositoryDao {
	public void addToRedis(String key, HashMap<String,String> hashvalue);
	public HashMap<String,String> readFromRedis(String key);
	public void updateToRedis(String key, HashMap<String,String> hashValue);
	public void deleteFromRedis(String key);
}
