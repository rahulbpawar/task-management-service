package com.example.task.service;

import com.example.task.dto.TaskDto;
import com.example.task.entity.Task;
import com.example.task.exception.TaskException;
import org.apache.coyote.BadRequestException;

public interface TaskService {

    Task create(TaskDto taskDto);
    Task update(TaskDto taskDto);
    Task get(String id);
    Task delete(String id);

}
