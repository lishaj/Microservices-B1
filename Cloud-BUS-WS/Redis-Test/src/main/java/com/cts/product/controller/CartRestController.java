package com.cts.product.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.model.ItemLine;
import com.cts.product.repository.CarRepositoryImpl;

@RestController
@CrossOrigin
@RefreshScope
@RequestMapping("/api/cart")
public class CartRestController {

	@Autowired
	private CarRepositoryImpl cartDao;

	@PostMapping("/{userName}")
	public ItemLine displayOrders(@RequestBody ItemLine itemLine, @PathVariable("userName") String user) {

		// Item i1 = new Item(1, "Pen", 10000);
		// Item i2 = new Item(2, "Mobile", 45000);

		// ItemLine il = new ItemLine(i2, 4);

		cartDao.save(user, itemLine);

		System.out.println(">>>>> SAVED ::: ");
		return itemLine;

	}

	@GetMapping("/{userName}")
	public List<ItemLine> getCartItems(@PathVariable("userName") String user) {

		List<ItemLine> cartItems = cartDao.findAll(user);

		return cartItems;

	}

	@DeleteMapping("/{userName}")
	public void clearCart(@PathVariable("userName") String user) {

		cartDao.clear(user);
		System.out.println(">>>> Cleared....");
	}

}
