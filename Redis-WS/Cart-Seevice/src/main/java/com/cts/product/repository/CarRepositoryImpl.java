package com.cts.product.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.cts.product.model.ItemLine;

@Repository
public class CarRepositoryImpl {

	@Autowired
	private RedisTemplate<String, String> template;

	// inject the template as ListOperations
	// can also inject as Value, Set, ZSet, and HashOperations
	@Resource(name = "redisTemplate")
	private ListOperations<String, ItemLine> listOps;

	public ItemLine save(String user, ItemLine itemLine) {
		listOps.leftPush(user, itemLine);
		return itemLine;
	}

	public List<ItemLine> findAll(String user) {
		return listOps.range(user, 0, -1);
	}

	public void clear(String user) {
		template.delete(user);
	}
}
