package com.cts.brownfield.pss;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.brownfield.pss.model.Item;
import com.cts.brownfield.pss.model.ItemLine;
import com.cts.brownfield.pss.repository.CarRepositoryImpl;

@SpringBootApplication
public class RedisTestApplication {

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(RedisTestApplication.class, args);
		
		CarRepositoryImpl bean = ac.getBean(CarRepositoryImpl.class);
	
		Item i=new Item(13, "Mobile", 45000);
		ItemLine il=new ItemLine(i, 4);
		//bean.save("user2", il);
		
		List<ItemLine> allItems = bean.findAll("user2");
		
		for(ItemLine itemLine:allItems) {
			System.out.println(itemLine.getItem().getId());
			System.out.println(itemLine.getItem().getName());
			System.out.println(itemLine.getItem().getPrice());
			System.out.println("----------------------------------");
		}
		
		
				
		
	}

}
