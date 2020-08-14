package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.model.Item;
import com.cts.product.model.ItemLine;
import com.cts.product.repository.CarRepositoryImpl;

@SpringBootApplication
public class CartSeeviceApplication {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(CartSeeviceApplication.class, args);
		
		CarRepositoryImpl cr = ac.getBean(CarRepositoryImpl.class);
		
		Item i1=new Item(1, "Pen", 10000);
		Item i2=new Item(2, "Mobile", 45000);
		
		ItemLine il=new ItemLine(i2, 4);
		//cr.save("praveen", il);
		
		//System.out.println("---- DOne ");
		
		
		cr.findAll("praveen").forEach(itemLine->{
			System.out.println(itemLine.getItem().getId());
			System.out.println(itemLine.getItem().getName());
			System.out.println(itemLine.getItem().getPrice());
			System.out.println("------------------------------------");
			
		});
		
		
		
		
	
		
		
		
	}

}
