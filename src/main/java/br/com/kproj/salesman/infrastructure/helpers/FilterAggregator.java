package br.com.kproj.salesman.infrastructure.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class FilterAggregator {

	private List<Filter> filters = new ArrayList<>();
	
	
	public static FilterAggregator build() {
	
		return new FilterAggregator();
	}
	
	public FilterAggregator add(Filter filter) {
		
		if (filter == null || filter.getObject() == null) {
			return this;
		}
		
		this.filters.add(filter);
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Filter<T> findFilter(String name) {
		
		int indexOf = filters.indexOf(Filter.build(name, null));
		
		if (indexOf > -1) {
			return (Filter<T>) this.filters.get(indexOf);
		}
		
		return (Filter<T>) Filter.nullObject();
	}
	
	public void merge(FilterAggregator aggregator) {
		List<Filter> result = aggregator.getFilters();
		
		for (Filter filter : result) {
			if (this.findFilter(filter.getName()).isNullObject()) {
				this.add(filter);
			}
		}
	}

	public FilterAggregator generateFilters(String filterQuery) {
        Collection<Filter> filters = FilterQuery.getFilters(filterQuery);
        this.getFilters().addAll(filters);
		return this;
	}

	public List<Filter> getFilters() {
		return this.filters;
	}
}
