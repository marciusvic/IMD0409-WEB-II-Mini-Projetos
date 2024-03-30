package com.jeanlima.springmvcdatajpaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeanlima.springmvcdatajpaapp.model.Curso;
import com.jeanlima.springmvcdatajpaapp.service.CursoService;

import java.util.List;


@Controller
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    CursoService cursoService;
    
    @RequestMapping("/getListaCursos")
    public String getListaCursos(Model model) {
        List<Curso> cursos = cursoService.getCursos();
        model.addAttribute("cursos", cursos);
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
    @GetMapping("/updateCurso/{id}")
    public String updateCurso(@ModelAttribute("id") Integer id, Model model){
        Curso curso = cursoService.getCurso(id);
        model.addAttribute("curso", curso);
        return "curso/formEditCurso";
    }
    @RequestMapping("/updateCurso")
    public String updateCurso(@ModelAttribute("curso") Curso curso, Model model){
        cursoService.atualizarCurso(curso);
        model.addAttribute("curso", curso);
        return "redirect:/curso/getListaCursos";
    }
    @GetMapping("/deleteCurso/{id}")
    public String deleteCurso(@ModelAttribute("id") Integer id){
        cursoService.deleteCurso(id);
        return "redirect:/curso/getListaCursos";
    }
}
