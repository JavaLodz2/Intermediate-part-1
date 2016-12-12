package sda.code.intermediate.part1.exercises.patterns;

import sda.code.intermediate.part1.exercises.data.Item;

public class ItemBuilder extends ProductBuilder<ItemBuilder, Item> {
	private Double weight;

	public ItemBuilder withWeight(Double weight) {
		this.weight = weight;
		return this;
		//Item builder zwraca sam siebie aby mogl byc builderem.
		//
		//throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	protected void validate() {
		//Wywolanie metody validate z klasy rodzica
		super.validate();
		if(weight<=0) throw new InvalidBuilderState(""); 
		//throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Item build() {
		validate();
		return new Item(this.name, this.price, this.weight);
		
		/*	Metoda build musi zwrocic typ Item poniwaz klasa ItemBuilder rozszerza
		 * 	ProductBuilder ktory przyjmuje parametry <ItemBuilder, Item> a zwraca drugi
		 * 	typ Item
		 */
		//throw new UnsupportedOperationException("Not implemented yet");
	}

}
