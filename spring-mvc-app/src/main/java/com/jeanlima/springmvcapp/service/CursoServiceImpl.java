package com.jeanlima.springmvcapp.service;

import java.util.ArrayList;
import java.util.List;

import com.jeanlima.springmvcapp.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoServiceImpl implements CursoService{
    public List<Curso> cursos = new ArrayList<Curso>();

    public CursoServiceImpl(){
        try{
            this.cursos.add(new Curso("BTI"));
            this.cursos.add(new Curso("EngSoft"));
            this.cursos.add(new Curso("EngComp"));
            this.cursos.add(new Curso("CienComp"));
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
    @Override
    public void salvarCurso(Curso curso){
        try{
            this.cursos.add(curso);
            System.out.println(cursos);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
    @Override
    public List<Curso> getListaCursos() {
        return this.cursos;
    }

}
