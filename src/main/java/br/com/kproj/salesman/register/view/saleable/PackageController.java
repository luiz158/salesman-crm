package br.com.kproj.salesman.register.view.saleable;

import br.com.kproj.salesman.infrastructure.entity.saleable.*;
import br.com.kproj.salesman.infrastructure.exceptions.ValidationException;
import br.com.kproj.salesman.infrastructure.helpers.NormalizeEntityRequest;
import br.com.kproj.salesman.infrastructure.repository.Pager;
import br.com.kproj.salesman.register.application.contract.saleable.PackageService;
import br.com.kproj.salesman.infrastructure.entity.saleable.Package;
import br.com.kproj.salesman.register.infrastructure.validators.SaleableValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@RestController
public class PackageController {

    @Autowired
    private PackageService service;

    @Autowired
    private SaleableValidator validator;

    @Autowired
    private NormalizeEntityRequest normalizeEntityRequest;

    @InitBinder(value = {"packageUnit"})
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);

        
    }

    @RequestMapping(value = "/saleable/packages/save", method = RequestMethod.POST)
    public @ResponseBody Package save(@ModelAttribute @Validated Package packageUnit, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors());
        }

        Package packageResult = service.register(packageUnit);

        return packageResult;
    }

    @RequestMapping(value = "/saleable/packages/save", method = RequestMethod.PUT)
    public @ResponseBody
    SaleableUnit update(@ModelAttribute @Validated Package packageUnit, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors());
        }
        normalizeEntityRequest.addFieldsToUpdate(packageUnit);
        SaleableUnit saleable = service.register(packageUnit);

        return saleable;
    }

    @RequestMapping("/saleable/packages/list")
    public ModelAndView list(@PageableDefault(page=0, size=150000)Pageable pageable, Model model) {

        Pager pager = Pager.binding(pageable);

        Iterable<Package> result = this.service.findAll(pager);

        model.addAttribute("products", result);
        return new ModelAndView("/products/list-items");
    }
    
    @RequestMapping(value="/saleable/packages/{packageId}")
    public ModelAndView viewInfo(@PathVariable Long packageId, Model model) {
        
        Optional<Package> result = this.service.getOne(packageId);

        model.addAttribute("product", result.isPresent() ? result.get(): null);
        return new ModelAndView("/products/edit");
    }

    @RequestMapping(value = "/saleable/packages/{packageId}/json", method = RequestMethod.GET)
    public @ResponseBody
    SaleableUnit getProduct(@PathVariable Long packageId) {

        Optional<Package> saleable = service.getOne(packageId);

        return saleable.isPresent() ? saleable.get() : null;
    }

    @RequestMapping(value="/saleable/packages/create")
    public ModelAndView newProduct() {

        return new ModelAndView("/products/edit");
    }

}
