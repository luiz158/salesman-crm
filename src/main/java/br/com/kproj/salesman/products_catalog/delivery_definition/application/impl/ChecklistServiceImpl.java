package br.com.kproj.salesman.products_catalog.delivery_definition.application.impl;


import br.com.kproj.salesman.products_catalog.delivery_definition.application.ChecklistFacade;
import br.com.kproj.salesman.products_catalog.delivery_definition.domain.model.checklist.Checklist;
import br.com.kproj.salesman.products_catalog.delivery_definition.domain.model.checklist.ChecklistRepository;
import br.com.kproj.salesman.products_catalog.delivery_definition.domain.model.tasks.Task;
import br.com.kproj.salesman.infrastructure.repository.BaseRepository;
import br.com.kproj.salesman.infrastructure.service.BaseModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("checklistFacadeTaskTemplateModule")
public class ChecklistServiceImpl extends BaseModelServiceImpl<Checklist> implements ChecklistFacade {

    private ChecklistRepository repository;

    @Autowired
    public ChecklistServiceImpl(ChecklistRepository repository) {
        this.repository = repository;
    }


    @Override
    public Collection<Checklist> findAll(Task task) {
        return repository.findAll(task);
    }

    @Override
    public void delete(Checklist checklist) {
        repository.delete(checklist);
    }


    @Override
    public BaseRepository<Checklist, Long> getRepository() {
        return repository;
    }


}