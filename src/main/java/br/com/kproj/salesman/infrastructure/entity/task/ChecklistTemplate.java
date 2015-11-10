package br.com.kproj.salesman.infrastructure.entity.task;


import br.com.kproj.salesman.infrastructure.entity.Identifiable;

import javax.persistence.*;

@Entity
@Table(name="checklist_template")
public class ChecklistTemplate extends Identifiable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="task_template_id")
    private TaskTemplate taskTemplate;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskTemplate getTaskTemplate() {
        return taskTemplate;
    }

    public void setTaskTemplate(TaskTemplate taskTemplate) {
        this.taskTemplate = taskTemplate;
    }
}