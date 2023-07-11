package com.goit.module15_hw_sprinbootsecurity.repository;

import com.goit.module15_hw_sprinbootsecurity.dto.NoteDto;
import com.goit.module15_hw_sprinbootsecurity.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
