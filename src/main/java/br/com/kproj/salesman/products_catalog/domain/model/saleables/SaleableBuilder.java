package br.com.kproj.salesman.products_catalog.domain.model.saleables;


import br.com.kproj.salesman.infrastructure.entity.builders.AbstractBuilder;

import java.math.BigDecimal;

public class SaleableBuilder extends AbstractBuilder<SaleableUnit>  {

	public SaleableBuilder() {
		this.entity = new SaleableUnit();
	}

	public SaleableBuilder(Long id) {
		this();
		this.entity.setId(id);
	}

	public SaleableBuilder withPrice(BigDecimal price) {
		this.entity.setPrice(price);
		return this;
	}

	public static SaleableBuilder createSaleable(Long id) {
		return new SaleableBuilder(id);
	}

	public static SaleableBuilder createSaleable() {
		return new SaleableBuilder();
	}
}
