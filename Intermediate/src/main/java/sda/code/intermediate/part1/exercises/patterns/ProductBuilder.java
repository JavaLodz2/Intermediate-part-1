package sda.code.intermediate.part1.exercises.patterns;

import java.math.BigDecimal;

@SuppressWarnings("unchecked")
public abstract class ProductBuilder<T, R> {
	protected String name;
	protected BigDecimal price;

	public T withName(String name) {
		this.name = name;
		// Builder rozni si� od settera ze zwraca sam siebie
		return (T) this;
	}

	public T withPrice(String price) {

		try {
			this.price = new BigDecimal(price);
			return (T) this;
		} catch (NumberFormatException e) {
			throw new InvalidBuilderState("");
		}
	}

	protected void validate() {

		if (name == null || name.isEmpty()) {
			throw new InvalidBuilderState("");
		}
		if (price == null) {
			throw new InvalidBuilderState("");
		}
		if (price.doubleValue() <= 0) {
			throw new InvalidBuilderState("");
		}
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	public abstract R build();
}
