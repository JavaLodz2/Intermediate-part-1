package sda.code.intermediate.part1.exercises.patterns;

import sda.code.intermediate.part1.exercises.data.Service;

public class ServiceBuilder extends ProductBuilder<ServiceBuilder, Service> {
	private Integer time;

	public ServiceBuilder withTime(Integer time) {
		this.time = time;
		return this;
		//Servicebuilder zwraca sam siebie aby mogl byc builderem.
		//throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	protected void validate() {
		//Wywolanie metody validate z klasy rodzica
		super.validate();
		if(time<=0) {
			throw new InvalidBuilderState("");
		}
		//throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Service build() {
		validate();
		return new Service(this.name, this.price, this.time);
		//throw new UnsupportedOperationException("Not implemented yet");
	}

}
