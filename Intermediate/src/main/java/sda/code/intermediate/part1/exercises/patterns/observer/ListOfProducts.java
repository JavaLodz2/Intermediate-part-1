package sda.code.intermediate.part1.exercises.patterns.observer;

import java.util.LinkedList;
import java.util.List;

import sda.code.intermediate.part1.exercises.data.Product;

public class ListOfProducts implements Publisher<Product> {

	final List<Product> products;
	final List<Subscriber<Product>> subscribers;

	public ListOfProducts() {
		products = new LinkedList<>();
		subscribers = new LinkedList<>();
	}

	public void add(Product product) {
		products.add(product);
		fireEvent(new ProductAdded(product));
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	public void remove(Product product) {
//		if(!products.isEmpty()){
			if(products.remove(product)){
				
				fireEvent(new ProductRemoved(product));
			}
		//}
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public void subscribe(Subscriber<Product> subscriber) {
		subscribers.add(subscriber);
		
		for(Product p : products){
			fireEvent(new ProductAdded(p));
		}
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	private void fireEvent(Event<Product> event) {
		for (Subscriber<Product> s : subscribers) {
			s.handle(event);
		}
		// throw new UnsupportedOperationException("Not implemented yet");
	}
}
