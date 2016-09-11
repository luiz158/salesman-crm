package br.com.kproj.salesman.delivery.infrastructure.generatebysalesorder.convert;

import br.com.kproj.salesman.infrastructure.entity.builders.TaskCostBuilder;
import br.com.kproj.salesman.infrastructure.entity.task.TaskEntity;
import br.com.kproj.salesman.infrastructure.entity.task.TaskCost;
import br.com.kproj.salesman.infrastructure.entity.task.TaskCostTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;


public class TaskCostTemplateToTaskCost implements Converter<TaskCostTemplate, TaskCost> {

    private TaskEntity taskEntity;

    public TaskCostTemplateToTaskCost(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }

    @Override
    public TaskCost convert(TaskCostTemplate source) {
        return TaskCostBuilder.createTaskCost()
                .withCost(source.getCost())
                .withDescription(StringUtils.EMPTY)
                .withisInternal(source.getIsInternal())
                .withTask(taskEntity).build();

    }

    public static TaskCostTemplateToTaskCost create(TaskEntity taskEntity) {
        return new TaskCostTemplateToTaskCost(taskEntity);
    }
}
