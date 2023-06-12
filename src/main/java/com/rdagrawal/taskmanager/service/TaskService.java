package com.rdagrawal.taskmanager.service;

import com.rdagrawal.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    private SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEntity addTask(String title, String description, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadlineFormatter.parse(deadline));
        task.setStatus(false);
        tasks.add(task);
        taskId++;
        return task;
    }

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id) {
        for (TaskEntity task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public TaskEntity updateTask(int taskId, String Description, String deadline, Boolean status) throws ParseException {
        TaskEntity task = getTaskById(taskId);
        if(task==null){
            return null;
        }
        if(Description != null)
            task.setDescription(Description);
        if(deadline != null)
            task.setDeadline(deadlineFormatter.parse(deadline));
        if(status != null)
            task.setStatus(status);
        return task;
    }

}
