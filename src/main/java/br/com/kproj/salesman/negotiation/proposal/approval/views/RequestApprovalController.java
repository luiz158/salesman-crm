package br.com.kproj.salesman.negotiation.proposal.approval.views;

import br.com.kproj.salesman.infrastructure.entity.builders.BusinessProposalBuilder;
import br.com.kproj.salesman.infrastructure.entity.builders.RequestApprovalBuilder;
import br.com.kproj.salesman.infrastructure.entity.proposal.requestapproval.RequestApproval;
import br.com.kproj.salesman.infrastructure.security.helpers.SecurityHelper;
import br.com.kproj.salesman.negotiation.proposal.approval.application.RequestApprovalApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static br.com.kproj.salesman.infrastructure.entity.builders.BusinessProposalBuilder.createBusinessProposal;

@RestController
public class RequestApprovalController {


    @Autowired
    private RequestApprovalApplication application;

    @Autowired
    private SecurityHelper security;



    @RequestMapping(value = "/request-approval/business-proposal/{proposalId}", method = RequestMethod.POST)
    public @ResponseBody void create(@PathVariable Long proposalId) {

        RequestApproval requestApproval = RequestApprovalBuilder.createRequestApproval()
                .withProposal(BusinessProposalBuilder.createBusinessProposal(proposalId).build())
                .withStatus(RequestApproval.RequestApprovalStatus.WAITING)
                .withUserRequester(security.getPrincipal().getUser()).build();

        application.register(requestApproval);
    }



}