package com.jeanlima.springmvcapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.jeanlima.springmvcapp.model.Curso;

@Service
public interface CursoService {

    public void salvarCurso(Curso curso);
    public List<Curso> getListaCursos();
    
}