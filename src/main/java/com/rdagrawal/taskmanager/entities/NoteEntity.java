package com.rdagrawal.taskmanager.entities;

import lombok.Data;

@Data
public class NoteEntity {
     private int id;
     private String title;
     private String body;
}