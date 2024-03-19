package com.jeanlima.springmvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jeanlima.springmvcapp.service.CursoService;
import com.jeanlima.springmvcapp.model.Curso;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    @Qualifier("cursoServiceImpl")
    CursoService cursoService;

    @RequestMapping("/getListaCursos")
    public String showListaCursos(Model model){
        List<Curso> cursos = cursoService.getListaCursos();
        model.addAttribute("cursos",cursos);
        return "curso/listaCursos";
    }

    @RequestMapping("/showForm")
    public String showFormCurso(Model model){
        model.addAttribute("curso", new Curso());
        return "curso/formCurso";
    }

    @RequestMapping("/addCurso")
    public String showFormCurso(@ModelAttribute("curso") Curso curso,  Model model){
        cursoService.salvarCurso(curso);
        model.addAttribute("curso", curso);
        return "curso/paginaCurso";
    }

}
