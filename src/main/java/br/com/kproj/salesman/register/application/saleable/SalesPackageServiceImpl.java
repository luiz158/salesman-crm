package br.com.kproj.salesman.register.application.saleable;

import br.com.kproj.salesman.infrastructure.entity.saleable.SalePackage;
import br.com.kproj.salesman.infrastructure.entity.saleable.SaleableUnit;
import br.com.kproj.salesman.infrastructure.exceptions.ValidationException;
import br.com.kproj.salesman.infrastructure.repository.BaseRepository;
import br.com.kproj.salesman.infrastructure.repository.Saleable.SalesPackageRepository;
import br.com.kproj.salesman.infrastructure.service.BaseModelServiceImpl;
import br.com.kproj.salesman.register.application.contract.saleable.SalePackageService;
import br.com.kproj.salesman.register.domain.contract.SaleableUnitDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.kproj.salesman.infrastructure.helpers.HandlerErrors.hasErrors;
import static com.google.common.collect.Sets.newHashSet;

@Service
public class SalesPackageServiceImpl extends BaseModelServiceImpl<SalePackage> implements SalePackageService {

    private SaleableUnitDomainService domainService;

    private SalesPackageRepository salesPackageRepository;

    @Autowired
    public SalesPackageServiceImpl(SalesPackageRepository salesPackageRepository, SaleableUnitDomainService domainService) {
        this.salesPackageRepository = salesPackageRepository;
        this.domainService = domainService;
    }

    @Override
    public SalePackage register(SalePackage salePackageItem) {
        domainService.verifyPreconditionToSave(salePackageItem);
        return super.save(salePackageItem);
    }

    @Override
    public SalePackage addProductOrService(SalePackage salePackage, SaleableUnit saleable) {

        Optional<SalePackage> salePackageLoaded = salesPackageRepository.getOne(salePackage.getId());

        if (!salePackageLoaded.isPresent()) {
            hasErrors(newHashSet("salepackage.not.found")).throwing(ValidationException.class);
        }

        salePackageLoaded.get().addSaleableUnit(saleable);

        return salePackageLoaded.get();
    }

    @Override
    public SalePackage removeProductOrService(SalePackage salePackage, SaleableUnit saleable) {

        Optional<SalePackage> salePackageLoaded = salesPackageRepository.getOne(salePackage.getId());

        if (!salePackageLoaded.isPresent()) {
            hasErrors(newHashSet("salepackage.not.found")).throwing(ValidationException.class);
        }

        salePackageLoaded.get().removeSaleableUnit(saleable);

        return salePackageLoaded.get();
    }

    public Optional<SalePackage> getOne(Long id) {
        return salesPackageRepository.getOne(id);
    }

    @Override
    public BaseRepository<SalePackage, Long> getRepository() {
        return salesPackageRepository;
    }

}
