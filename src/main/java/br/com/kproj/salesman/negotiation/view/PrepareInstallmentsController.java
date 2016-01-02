package br.com.kproj.salesman.negotiation.view;

import br.com.kproj.salesman.infrastructure.entity.builders.SaleableUnitBuilder;
import br.com.kproj.salesman.negotiation.view.dto.UpdatePackageItemsDTO;
import br.com.kproj.salesman.negotiation.view.dto.UpdateQuantityPriceItemsDTO;
import br.com.kproj.salesman.negotiation.view.dto.session.ProposalSaleableItemDTO;
import br.com.kproj.salesman.negotiation.view.dto.session.ProposalSaleablesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class PrepareInstallmentsController {


    @Autowired
    private ProposalSaleablesDTO proposalSaleablesDTO;



    @RequestMapping(value="/proposals/select-saleables", method = RequestMethod.POST)
    public ModelAndView addItem(@ModelAttribute UpdatePackageItemsDTO item, Model model) {

        proposalSaleablesDTO.mergeItems(item);

        model.addAttribute("proposalSaleables", proposalSaleablesDTO);
        return new ModelAndView("/clients/proposal/saleables-items");
    }

    @RequestMapping(value="/proposals/add-saleable/{saleableId}", method = RequestMethod.PUT)
    public ModelAndView addSaleable(@PathVariable Long saleableId, Model model) {

        proposalSaleablesDTO.add(SaleableUnitBuilder.createSaleableUnit(saleableId).build());

        model.addAttribute("proposalSaleables", proposalSaleablesDTO);
        return new ModelAndView("/clients/proposal/saleables-items");
    }

    @RequestMapping(value="/proposals/package/{packageId}/items", method = RequestMethod.GET)
    public ModelAndView showPackageItems(@PathVariable Long packageId, Model model) {

        Optional<ProposalSaleableItemDTO> result = proposalSaleablesDTO.getByPackageId(packageId);

        model.addAttribute("proposalSaleableItem", result.isPresent() ? result.get() : null);
        return new ModelAndView("/clients/proposal/modal/select-items-modal");
    }

    @RequestMapping(value="/proposals/saleables/{saleableId}", method = RequestMethod.PUT)
    public ModelAndView updateItemSelected(@ModelAttribute UpdateQuantityPriceItemsDTO dto,
                                           @PathVariable Long saleableId, Model model) {
        dto.setSaleableId(saleableId);
        proposalSaleablesDTO.updateRootItem(dto);
        model.addAttribute("proposalSaleables", proposalSaleablesDTO);
        return new ModelAndView("/clients/proposal/saleables-items");
    }

    @RequestMapping(value="/proposals/saleables/{saleableId}", method = RequestMethod.DELETE)
    public ModelAndView deleteItem(@PathVariable Long saleableId, Model model) {

        proposalSaleablesDTO.deleteRootItem(saleableId);
        model.addAttribute("proposalSaleables", proposalSaleablesDTO);
        return new ModelAndView("/clients/proposal/saleables-items");
    }
}
