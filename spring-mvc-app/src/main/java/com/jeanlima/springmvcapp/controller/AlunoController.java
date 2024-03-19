package com.jeanlima.springmvcapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeanlima.springmvcapp.model.Aluno;
import com.jeanlima.springmvcapp.model.Curso;
import com.jeanlima.springmvcapp.service.AlunoService;
import com.jeanlima.springmvcapp.service.CursoService;
import com.jeanlima.springmvcapp.service.MockDataService;


@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    @Qualifier("alunoServiceImpl")
    AlunoService alunoService;

    @Autowired
    CursoService cursoService;

    @Autowired
    MockDataService mockDataService;


    @RequestMapping("/showForm")
    public String showFormAluno(Model model){
        List<Curso> cursos = cursoService.getListaCursos();
        String nomes[] = new String[cursos.size()];
        for (Curso curso : cursos) {
            nomes[cursos.indexOf(curso)] = curso.getNome();
        }
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("cursos", nomes);
        model.addAttribute("sistemasOperacionais", mockDataService.getSistemasOperacionais());
        return "aluno/formAluno";
    }

    @RequestMapping("/addAluno")
    public String showFormAluno(@ModelAttribute("aluno") Aluno aluno,  Model model){

        alunoService.salvarAluno(aluno);
        model.addAttribute("aluno", aluno);
        return "aluno/paginaAluno";
    }

    @RequestMapping("/getListaAlunos")
    public String showListaAluno(Model model){
        List<Aluno> alunos = alunoService.getListaAluno();
        model.addAttribute("alunos",alunos);
        return "aluno/listaAlunos";
    }
    @RequestMapping("/getListaAlunosPorCurso")
    public String showListaAlunoPorCurso(Model model){
        List<Curso> cursos = cursoService.getListaCursos();
        String nomes[] = new String[cursos.size()];
        for (Curso curso : cursos) {
            nomes[cursos.indexOf(curso)] = curso.getNome();
        }
        Map<String, List<Aluno>> alunosPorCurso = new HashMap<>();
        for (String curso : nomes) {
            alunosPorCurso.put(curso, alunoService.getListaAlunoPorCurso(curso));
        }
        model.addAttribute("alunosPorCurso",alunosPorCurso);
        return "aluno/listaAlunosCurso";
    }
    @RequestMapping("/getListaAlunosPorLinguagem")
    public String showListaAlunoPorLinguagem(Model model){
        String[] linguagens = mockDataService.getLinguagens();
        Map<String, List<Aluno>> alunosPorLinguagem = new HashMap<>();
        for (String linguagem : linguagens) {
            alunosPorLinguagem.put(linguagem, alunoService.getListaAlunoLinguagem(linguagem));
        }
        model.addAttribute("alunosPorLinguagem",alunosPorLinguagem);
        System.out.println(alunosPorLinguagem);
        return "aluno/listaAlunosLinguagem";
    }
    @RequestMapping("/getListaAlunosPorSistema")
    public String showListaAlunoPorSistemaOperacional(Model model){
        String[] sistemasOperacionais = mockDataService.getSistemasOperacionais();
        Map<String, List<Aluno>> alunosPorSistemaOperacional = new HashMap<>();
        for (String sistemaOperacional : sistemasOperacionais) {
            alunosPorSistemaOperacional.put(sistemaOperacional, alunoService.getListaAlunoSistemasOperacionaisEmComum(sistemaOperacional));
        }
        model.addAttribute("alunosPorSistemaOperacional",alunosPorSistemaOperacional);
        return "aluno/listaAlunosSO";
    }
    @RequestMapping("/detalhesAluno/{id}")
    public String detalhesAluno(@ModelAttribute("id") Integer id, Model model){
        Aluno aluno = alunoService.getAlunoById(id);
        model.addAttribute("aluno",aluno);
        return "aluno/detalhesAluno";
    }
    @GetMapping("/deleteAluno/{id}")
    public String deletarAluno(@ModelAttribute("id") Integer id, Model model){
        Aluno aluno = alunoService.getAlunoById(id);
        alunoService.deletarAluno(aluno);
        return "redirect:/aluno/getListaAlunos";
    }
}
