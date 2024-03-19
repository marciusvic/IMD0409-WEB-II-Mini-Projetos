package com.jeanlima.springmvcapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jeanlima.springmvcapp.model.Aluno;

@Component
public class AlunoServiceImpl implements  AlunoService{

    public List<Aluno> alunos = new ArrayList<Aluno>();    

    @Override
    public void salvarAluno(Aluno aluno) {
        System.out.println(aluno.toString());
        try{
            this.alunos.add(aluno);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    @Override
    public void deletarAluno(Aluno aluno) {
       this.alunos.remove(aluno);
    }

    @Override
    public Aluno getAlunoById(Integer id) {
        for (Aluno aluno : alunos) {
            if(aluno.getId() == id){
                return aluno;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> getListaAluno() {
        return this.alunos;
    }

    @Override
    public List<Aluno> getListaAlunoPorCurso(String curso) {
        List<Aluno> alunosPorCurso = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getCurso().equalsIgnoreCase(curso)) {
                alunosPorCurso.add(aluno);
            }
        }
        return alunosPorCurso;
    }
    @Override
    public List<Aluno> getListaAlunoLinguagem(String linguagem) {
        List<Aluno> alunosPorLinguagem = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getLinguagem().equalsIgnoreCase(linguagem)) {
                alunosPorLinguagem.add(aluno);
            }
        }
        return alunosPorLinguagem;
    }
    @Override
    public List<Aluno> getListaAlunoSistemasOperacionaisEmComum(String sistemaOperacional){
        List<Aluno> alunosPorSistemaOperacional = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getSistemasOperacionas().contains(sistemaOperacional)) {
                alunosPorSistemaOperacional.add(aluno);
            }
        }
        return alunosPorSistemaOperacional;
    }
    @Override
    public List<Aluno> deletarAlunoPorId(Integer id){
        for (Aluno aluno : alunos) {
            if(aluno.getId() == id){
                alunos.remove(aluno);
            }
        }
        return alunos;
    }
}
