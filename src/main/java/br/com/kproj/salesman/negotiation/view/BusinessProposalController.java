package br.com.kproj.salesman.negotiation.view;

import br.com.kproj.salesman.infrastructure.entity.builders.SaleableUnitBuilder;
import br.com.kproj.salesman.infrastructure.entity.person.Person;
import br.com.kproj.salesman.infrastructure.entity.proposal.BusinessProposal;
import br.com.kproj.salesman.infrastructure.entity.saleable.SalePackage;
import br.com.kproj.salesman.infrastructure.entity.saleable.SaleableUnit;
import br.com.kproj.salesman.infrastructure.exceptions.ValidationException;
import br.com.kproj.salesman.infrastructure.helpers.NormalizeEntityRequest;
import br.com.kproj.salesman.infrastructure.repository.Pager;
import br.com.kproj.salesman.negotiation.application.NegotiationApplication;
import br.com.kproj.salesman.negotiation.infrastructure.validators.BusinessProposalDTOValidator;
import br.com.kproj.salesman.negotiation.view.dto.BusinessProposalDTO;
import br.com.kproj.salesman.negotiation.view.dto.UpdatePackageItemsDTO;
import br.com.kproj.salesman.negotiation.view.dto.UpdateQuantityPriceItemsDTO;
import br.com.kproj.salesman.negotiation.view.dto.session.ProposalSaleableItemDTO;
import br.com.kproj.salesman.negotiation.view.dto.session.ProposalSaleablesDTO;
import br.com.kproj.salesman.register.application.contract.ClientApplication;
import br.com.kproj.salesman.register.application.contract.saleable.SaleableApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class BusinessProposalController {

    @Autowired
    private NegotiationApplication service;

    @Autowired
    private NormalizeEntityRequest normalizeEntityRequest;

    @Autowired
    private BusinessProposalDTOValidator validator;

    @Autowired
    private ClientApplication clientApplication;

    @Autowired
    private SaleableApplication saleableApplication;

    @Autowired
    private ProposalSaleablesDTO proposalSaleablesDTO;

    @InitBinder(value = "businessProposalDTO")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/proposals/save", method = RequestMethod.POST)
    public @ResponseBody
    BusinessProposal save(@ModelAttribute @Validated BusinessProposalDTO businessProposalDTO,
                     BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors());
        }

        BusinessProposal result = businessProposalDTO.get(proposalSaleablesDTO);

        normalizeEntityRequest.doNestedReference(result);
        return service.register(result);

    }

    @RequestMapping(value = "/proposals/save", method = RequestMethod.PUT)
    public @ResponseBody void update(@ModelAttribute @Validated BusinessProposalDTO businessProposalDTO,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors());
        }

        BusinessProposal result = businessProposalDTO.get(proposalSaleablesDTO);
        normalizeEntityRequest.addFieldsToUpdate(result);
        service.register(result);
    }

    @RequestMapping(value="/proposals/persons/{idPerson}")
    public ModelAndView newProposal(Model model, @PathVariable Long idPerson) {

        Optional<Person> clientOptional  = clientApplication.getOne(idPerson);

        if (!clientOptional.isPresent()) {
            return new ModelAndView("redirect:/clients/list");
        }

        Iterable<SaleableUnit> saleable = saleableApplication.findAll(Pager.build().withPageNumer(1).withPageSize(10000));

        proposalSaleablesDTO.clear();

        model.addAttribute("saleables", saleable);
        model.addAttribute("client", clientOptional.get());
        return new ModelAndView("/clients/proposal/newProposal");
    }

}
