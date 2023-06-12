package shoppingcart;
import java.util.ArrayList;


import java.util.Iterator;

import products.Product;

public class ShoppingCart {
	ArrayList<CartLine> cartlineList = new ArrayList<CartLine>();

	public void addToCart(Product product) {
		if (productExists(product)) {
			addExistingProduct(product);
		}
		else {
			addNewProduct(product);
		}		
	}

	private void addNewProduct(Product product) {
		CartLine cline = new CartLine();
		cline.setProduct(product);
		cline.setQuantity(1);
		cartlineList.add(cline);
	}

	private void addExistingProduct(Product product) {
		for (CartLine cline : cartlineList) {
			if (isProductInCartLine(product, cline)) {
				cline.setQuantity(cline.getQuantity()+1);
				return;
			}
		}
	}
	
	private boolean productExists(Product product) {
		for (CartLine cline : cartlineList) {
			if (isProductInCartLine(product, cline)) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		System.out.println("Content of the shoppingcart:");
		for (CartLine cline : cartlineList) {
			System.out.println(cline.getQuantity() + " "
					+ cline.getProduct().getProductnumber() + " "
					+ cline.getProduct().getDescription() + " "
					+ cline.getProduct().getPrice());
		}
		System.out.println("Total price ="+getTotalPrice());
	}
	
	public double getTotalPrice(){
		double totalPrice = 0.0;
		for (CartLine cline : cartlineList) {
			totalPrice=totalPrice+(cline.getProduct().getPrice() * cline.getQuantity());
		}
		return totalPrice;
	}
	
	public void removeFromCart(Product product){
		Iterator<CartLine> iter = cartlineList.iterator();
		while (iter.hasNext()){
			CartLine cline = iter.next();
			if (isProductInCartLine(product, cline)){
				if (cline.getQuantity()>1){
					cline.setQuantity(cline.getQuantity()-1);
				}
				else{
					iter.remove();
				}
			}
		}	
	}

	private boolean isProductInCartLine(Product product, CartLine cline) {
		return cline.getProduct().getProductnumber().equals(product.getProductnumber());
	}
}
