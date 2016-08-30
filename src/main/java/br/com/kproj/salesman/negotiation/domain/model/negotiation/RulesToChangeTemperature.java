package br.com.kproj.salesman.negotiation.domain.model.negotiation;


import br.com.kproj.salesman.negotiation.domain.model.seller.Seller;

public interface RulesToChangeTemperature {

    Boolean isValidBusinessRulesFor(Seller seller, NegotiationChangeTemperature negotiation);
}