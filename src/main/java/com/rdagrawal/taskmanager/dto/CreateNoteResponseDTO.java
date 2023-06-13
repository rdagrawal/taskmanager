package com.rdagrawal.taskmanager.dto;

import com.rdagrawal.taskmanager.entities.NoteEntity;
import com.rdagrawal.taskmanager.service.NoteService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateNoteResponseDTO {
    private Integer taskId;
    private NoteEntity note;
    
}
