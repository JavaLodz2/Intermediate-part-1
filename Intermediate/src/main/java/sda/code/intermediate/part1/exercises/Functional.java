package sda.code.intermediate.part1.exercises;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import sda.code.intermediate.part1.exercises.data.Item;
import sda.code.intermediate.part1.exercises.data.Product;

public class Functional {

	public List<Integer> squares(List<Integer> list) {
		return list.stream().map(x->x*x).collect(Collectors.toList());
		//throw new UnsupportedOperationException("Not implemented yet");
	}

	public List<Integer> even(List<Integer> list) {
		return list.stream().filter(x->x % 2 ==0).collect(Collectors.toList());
		//throw new UnsupportedOperationException("Not implemented yet");
	}

	public Long countOdd(List<Integer> list) {
		return list.stream().filter(x -> Math.abs(x) % 2 == 1).collect(Collectors.counting());
		//throw new UnsupportedOperationException("Not implemented yet");
	}

	public Integer smallest(List<Integer> list) {
		return list.stream().reduce(Math::min).orElseThrow(IllegalArgumentException::new);
		//throw new UnsupportedOperationException("Not implemented yet");
	}

	private BigDecimal bruttoSum(Predicate<Product> policy, Function<BigDecimal, BigDecimal> tax,
			List<Product> products) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	private Predicate<Product> taxOnItems() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	private Function<BigDecimal, BigDecimal> itemTax(BigDecimal tax) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public BigDecimal cartBruttoSum(List<Product> products) {
		return bruttoSum(taxOnItems(), itemTax(new BigDecimal("0.42")), products);
	}

}
