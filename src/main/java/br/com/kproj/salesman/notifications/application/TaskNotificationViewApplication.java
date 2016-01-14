package br.com.kproj.salesman.notifications.application;

import br.com.kproj.salesman.infrastructure.entity.notification.TaskNotificationView;
import br.com.kproj.salesman.infrastructure.service.ModelService;

import java.util.Optional;


public interface TaskNotificationViewApplication extends ModelService<TaskNotificationView> {

    Optional<TaskNotificationView> register(TaskNotificationView view);
}
