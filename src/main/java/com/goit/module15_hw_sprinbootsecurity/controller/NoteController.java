package com.goit.module15_hw_sprinbootsecurity.controller;

import com.goit.module15_hw_sprinbootsecurity.dto.NoteDto;
import com.goit.module15_hw_sprinbootsecurity.entity.Note;
import com.goit.module15_hw_sprinbootsecurity.service.NoteService;
import jakarta.servlet.ServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/note")
@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @Secured({"ADMIN", "SUPER_ADMIN"})
    @GetMapping("/edit")
    public String showAddNoteForm(Note note) {
        return "add-note";
    }

    @Secured({"ADMIN", "SUPER_ADMIN"})
    @PostMapping("/edit")
    public String addNote(Note note, BindingResult result) {
        if (result.hasErrors()) {
            return "add-note";
        }
        noteService.add(note);
        return "redirect:/";
    }

    @Secured({"SUPER_ADMIN"})
    @GetMapping("/list")
    public String showAllNotes(Model model) {
        model.addAttribute("notes",noteService.listAll());
        return "index";
    }

    @Secured({"USER", "ADMIN", "SUPER_ADMIN"})
    @GetMapping("/list-ro")
    public String showAllNotesRO(Model model) {
        model.addAttribute("notes",noteService.listAll());
        return "index_user";
    }

    @Secured({"ADMIN", "SUPER_ADMIN"})
    @GetMapping("/list-rw")
    public String showAllNotesRW(Model model) {
        model.addAttribute("notes",noteService.listAll());
        return "index_rw";
    }

    @Secured({"ADMIN", "SUPER_ADMIN"})
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        NoteDto note = noteService.getById(id);

        model.addAttribute("note", note);
        return "update-note";
    }

    @Secured({"ADMIN", "SUPER_ADMIN"})
    @PostMapping("/update/{id}")
    public String updateNote(@PathVariable("id") long id, Note note, BindingResult result) {
        if (result.hasErrors()) {
            note.setId(id);
            return "update-note";
        }
        noteService.update(note);
        return "redirect:/";
    }

    @Secured({"SUPER_ADMIN"})
    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
