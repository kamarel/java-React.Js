package com.ecomApp.Ecom;

import com.ecomApp.Ecom.cart.Cart;
import com.ecomApp.Ecom.cart.CartServices;
import com.ecomApp.Ecom.orders.OrderServices;
import com.ecomApp.Ecom.orders.Orders;
import com.ecomApp.Ecom.products.Product;
import com.ecomApp.Ecom.products.ProductRepository;
import com.ecomApp.Ecom.products.ProductService;
import com.ecomApp.Ecom.users.User;
import com.ecomApp.Ecom.users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);

	}

	@Autowired
	OrderServices orderServices;
	@Autowired
	ProductService productService;
	@Autowired
	UserServices userServices;

	@Autowired
	CartServices cartServices;


	@Override
	public void run(String... args) throws

			Exception {
		productService.createProduct(new Product(1L,"phone", "https://wholesale.alegre.net.au/assets/full/S-IPHX-ALL-NIB.jpg?20201124095923", 199.99, "Phone"));
		productService.createProduct(new Product(2L,"Adidas tennis ", "https://tse3.mm.bing.net/th?id=OIP.JY3vfhOnpJPGpOxICQkasQHaHa&pid=Api&P=0", 99.99, "Shoes"));
		productService.createProduct(new Product(3L,"Bike", "https://tse1.mm.bing.net/th?id=OIP.j_xhcHLP7Wa98BPfjU7MzQHaFS&pid=Api&P=0", 302.99, "Sport"));
		productService.createProduct(new Product(4L,"Bass Guitar", "https://tse3.mm.bing.net/th?id=OIP.u0HbAVKGVdxThnm7rZdjNQHaLx&pid=Api&P=0", 88.99, "Music"));
		productService.createProduct(new Product(5L,"LapTop LG", "https://www.bhphotovideo.com/images/images2500x2500/lg_13z990_r_aas7u1_gram_i7_8565u_16gb_256ssd_1459831.jpg", 1500.56, "Electronic"));
		productService.createProduct(new Product(6L,"BasketBall", "https://tse3.mm.bing.net/th?id=OIP.TsAqc82ut8u1lTtUcDpIeQHaHe&pid=Api&P=0", 50.23, "Sport"));
		productService.createProduct(new Product(7L,"BasketBall", "https://tse2.mm.bing.net/th?id=OIP.WiL2dmQxKt7lvbfGFO3jmAHaHa&pid=Api&P=0", 20.13, "Clothes"));

		System.out.println(productService.getProductsByName("BASKETBALL"));

		//For Order
		orderServices.createProduct(new Orders(2, 23.2, 25, "02/25/2022"));
		System.out.println(orderServices.listAllProduct());
		//For User
		userServices.createNewUser(new User(2L, "Kamalre", "Malanda", "Phonenumber", "2510 falls of neuse", "raleign", "27609", "USA", "kamarelngunda@gmail.com", false));
		// for Cart

		cartServices.createProduct(new Cart(23));
	}
}

