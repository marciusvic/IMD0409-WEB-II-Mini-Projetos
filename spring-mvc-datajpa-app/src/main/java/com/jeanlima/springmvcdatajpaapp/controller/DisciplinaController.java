package com.jeanlima.springmvcdatajpaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jeanlima.springmvcdatajpaapp.model.Disciplina;
import com.jeanlima.springmvcdatajpaapp.service.CursoService;
import com.jeanlima.springmvcdatajpaapp.service.DisciplinaService;

import org.springframework.ui.Model;

import java.util.List;
@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @Autowired
    CursoService cursoService;

    @RequestMapping("/getListaDisciplinas")
    public String getListaDisciplinas(Model model) {
        List<Disciplina> disciplinas = disciplinaService.getDisciplinas();
        model.addAttribute("disciplinas", disciplinas);
        return "disciplina/listaDisciplinas";
    }
    
    @RequestMapping("/showForm")
    public String showFormDisciplina(Model model) {
        model.addAttribute("cursos", cursoService.getCursos());
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina/formDisciplina";
    }

    @RequestMapping("/addDisciplina")
    public String addDisciplina(Disciplina disciplina, Model model) {
        disciplinaService.salvarDisciplina(disciplina);
        return "redirect:/disciplina/getListaDisciplinas";
    }
}