package br.com.kproj.salesman.delivery2.tasks.application.impl;

import br.com.kproj.salesman.delivery2.tasks.application.TaskFacade;
import br.com.kproj.salesman.delivery2.tasks.domain.model.sales.SalesOrder;
import br.com.kproj.salesman.delivery2.tasks.domain.model.sales.SalesValidator;
import br.com.kproj.salesman.delivery2.tasks.domain.model.tasks.*;
import br.com.kproj.salesman.infrastructure.repository.BaseRepository;
import br.com.kproj.salesman.infrastructure.service.BaseModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TaskServiceImpl extends BaseModelServiceImpl<Task> implements TaskFacade {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskValidator validator;

    @Autowired
    private SalesValidator salesValidator;

    @Autowired
    private SubtaskValidator subtaskValidator;


    public Optional<Task> register(Task task) {
        validator.checkRules(task);
        Optional<Task> result = repository.save(task);

        return result;
    }

    @Override
    public Optional<Subtask> register(Subtask subtask) {
        subtaskValidator.checkRules(subtask);

        return repository.save(subtask);
    }

    @Override
    public Collection<Task> findAll(SalesOrder salesOrder) {
        return repository.findAll(salesOrder);
    }

    @Override
    public void generateByNewSalesOrder(SalesOrder salesOrder) {
        salesValidator.checkRules(salesOrder);
        repository.generateTaskFor(salesOrder);
    }

    @Override
    public BaseRepository<Task, Long> getRepository() {
        return repository;
    }
}
