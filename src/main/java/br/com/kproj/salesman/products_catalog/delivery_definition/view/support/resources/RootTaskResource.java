package br.com.kproj.salesman.products_catalog.delivery_definition.view.support.resources;


import br.com.kproj.salesman.products_catalog.delivery_definition.domain.model.tasks.RootTask;
import br.com.uol.rest.apiconverter.resources.Item;
import br.com.uol.rest.infrastructure.annotations.ResourceItem;
import br.com.uol.rest.infrastructure.annotations.Selectable;
import br.com.uol.rest.infrastructure.annotations.SuperClass;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id",
        "task",
        "region",
        "saleable",
        "links"
})
@ResourceItem(name="root-task-definitions", modelReference = RootTask.class, parent = SaleableResource.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RootTaskResource extends Item {

    private Long id;

    @SuperClass
    private TaskResource task;

    private RegionResource region;
    private SaleableResource saleable;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Selectable(expression = "of-region", noExpandAnyWay = true)
    public RegionResource getRegion() {
        return region;
    }

    public void setRegion(RegionResource region) {
        this.region = region;
    }

    @Selectable(expression = "of-saleable", noExpandAnyWay = true)
    public SaleableResource getSaleable() {
        return saleable;
    }

    public void setSaleable(SaleableResource saleable) {
        this.saleable = saleable;
    }

    @Selectable(expression = "is-a", expandByDefault = true)
    public TaskResource getTask() {
        return task;
    }

    public void setTask(TaskResource task) {
        this.task = task;
    }
}
