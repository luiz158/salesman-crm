package br.com.kproj.salesman.assistants.calendar.domain.model.activity;

import br.com.kproj.salesman.infrastructure.model.ModelIdentifiable;
import com.trex.shared.annotations.Model;

@Model
public class Type extends ModelIdentifiable {

    private Long id;

    private String name;


    @Override
    public Long getId() {
        return id;
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
}
