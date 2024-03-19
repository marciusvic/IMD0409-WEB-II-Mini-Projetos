package com.jeanlima.springmvcapp.service;

import org.springframework.stereotype.Component;

@Component
public class MockDataService {

    private final String[] cursos = {
        "BTI", "EngSoft", "EngComp", "CienComp"
    };
    private final String[] sistemasOperacionais = {
        "OSX", "Windows", "Linux"
    };
    private final String[] linguagens = {
        "Java", "C", "Python", "JavaScript"
    };
    public String[] getCursos() {
        return cursos;
    }
    public String[] getSistemasOperacionais() {
        return sistemasOperacionais;
    }
    public String[] getLinguagens() {
        return linguagens;
    }
    
    
}
