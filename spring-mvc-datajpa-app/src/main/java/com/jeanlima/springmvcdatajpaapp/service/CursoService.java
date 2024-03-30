package com.jeanlima.springmvcdatajpaapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeanlima.springmvcdatajpaapp.model.Curso;
import com.jeanlima.springmvcdatajpaapp.model.Disciplina;


@Service
public interface CursoService {
    public List<Curso> getCursos();
    public Curso getCurso(Integer id);
    public Curso getCursoById(Integer id);
    public void salvarCurso(Curso curso);
    public void deleteCurso(Integer id);
    public void atualizarCurso(Curso curso);
    public List<Disciplina> getDisciplinas();
}
