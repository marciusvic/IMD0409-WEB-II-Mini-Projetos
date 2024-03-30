package com.jeanlima.springmvcdatajpaapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeanlima.springmvcdatajpaapp.model.Curso;
import com.jeanlima.springmvcdatajpaapp.model.Disciplina;
import com.jeanlima.springmvcdatajpaapp.repository.CursoRepository;
import com.jeanlima.springmvcdatajpaapp.repository.DisciplinaRepository;


@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Override
    public void salvarCurso(Curso curso){
        cursoRepository.save(curso);
    }

    @Override
    public Curso getCurso(Integer id){
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Curso> getCursos(){
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCursoById(Integer id){
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCurso(Integer id){
        cursoRepository.deleteById(id);
    }
    @Override
    public void atualizarCurso(Curso curso){
        cursoRepository.save(curso);
    }

    @Override
    public List<Disciplina> getDisciplinas(){
        return disciplinaRepository.findAll();
    }
    
}
