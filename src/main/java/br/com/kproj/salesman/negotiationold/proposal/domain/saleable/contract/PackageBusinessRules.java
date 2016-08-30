package br.com.kproj.salesman.negotiationold.proposal.domain.saleable.contract;


import br.com.kproj.salesman.infrastructure.entity.proposal.ProposalSaleableItem;

import java.util.List;

public interface PackageBusinessRules {

    public Boolean verifyRules(List<ProposalSaleableItem> saleableItems);
}