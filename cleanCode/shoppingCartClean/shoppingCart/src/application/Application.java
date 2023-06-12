package application;
import products.Product;
import shoppingcart.ShoppingCart;


public class Application {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Product product1 = new Product("A123", 100.0, "TV");
		cart.addToCart(product1);
		Product product2 = new Product("A665", 75.0, "MP3 Player");
		cart.addToCart(product2);
		Product product3 = new Product("A665", 75.0, "MP3 Player");
		cart.addToCart(product3);
		
		cart.print();
		
		cart.removeFromCart(product3);
		cart.removeFromCart(product2);
		
		cart.print();
	}
}
