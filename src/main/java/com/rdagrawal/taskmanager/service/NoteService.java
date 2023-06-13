package com.rdagrawal.taskmanager.service;

import com.rdagrawal.taskmanager.entities.NoteEntity;
import com.rdagrawal.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {
    private TaskService taskService;
    private HashMap<Integer, TaskNotesHolder> taskNotesHolderHashMap = new HashMap<>();

    public NoteService(TaskService taskService){
        this.taskService=taskService;
    }

    class TaskNotesHolder{
        protected int noteId = 1;
        protected ArrayList<NoteEntity> noteArr = new ArrayList<>();
    }
    
    public List<NoteEntity> getNotesForTask(int taskId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task==null){
            return null;
        }
        if(taskNotesHolderHashMap.get(taskId) ==null){
            taskNotesHolderHashMap.put(taskId, new TaskNotesHolder());
        }
        return  taskNotesHolderHashMap.get(taskId).noteArr;
    }
    
    public NoteEntity addNoteForTask(int taskId, String title, String body){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task==null){
            return null;
        }
        if(taskNotesHolderHashMap.get(taskId)==null){
            taskNotesHolderHashMap.put(taskId, new TaskNotesHolder());
        }
        TaskNotesHolder taskNotesHolder = taskNotesHolderHashMap.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId((taskNotesHolder.noteId));
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.noteArr.add(note);
        taskNotesHolder.noteId++;
        return note;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
