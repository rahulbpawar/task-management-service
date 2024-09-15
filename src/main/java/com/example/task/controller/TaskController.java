package com.example.task.controller;

import com.example.task.dto.ApiResponse;
import com.example.task.dto.TaskDto;
import com.example.task.entity.Task;
import com.example.task.exception.TaskException;
import com.example.task.service.TaskService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping()
    public Task create(@RequestBody TaskDto taskDto) {
        return taskService.create(taskDto);
    }

//    @PutMapping
//    public ResponseEntity update (@RequestBody TaskDto taskDto) {
//        try {
//            ApiResponse<Task> response = ApiResponse.<Task>builder().statusCode(200).message("Success").data(taskService.update(taskDto)).error(null).build();
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (TaskException ex) {
//            ApiResponse response = ApiResponse.builder()
//                    .statusCode(ex.getStatusCode())
//                    .message("Error")
//                    .data(null)
//                    .error(ex.getMessage())
//                    .build();
//
//            return new ResponseEntity<>(response, HttpStatusCode.valueOf(ex.getStatusCode()));
//        }
//    }

    @PutMapping
    public ApiResponse<Task> update (@RequestBody TaskDto taskDto) {
        return ApiResponse.<Task>builder().statusCode(200).message("Success").data(taskService.update(taskDto)).error(null).build();
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable String id){
        return taskService.get(id);
    }

    @DeleteMapping("/{id}")
    public Task delete(@PathVariable String id) {
        return taskService.delete(id);
    }
}
