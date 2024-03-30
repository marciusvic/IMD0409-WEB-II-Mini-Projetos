package com.jeanlima.springmvcdatajpaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jeanlima.springmvcdatajpaapp.service.AlunoService;
import com.jeanlima.springmvcdatajpaapp.service.AvatarService;
import com.jeanlima.springmvcdatajpaapp.model.Aluno;
import com.jeanlima.springmvcdatajpaapp.model.Avatar;

import java.util.List;

@Controller
@RequestMapping("/avatar")
public class AvatarController {
    
    @Autowired
    AvatarService avatarService;

    @Autowired
    AlunoService alunoService;
    
    @RequestMapping("/getListaAvatares")
    public String getListaAvatares(Model model) {
        List<Avatar> avatares = avatarService.getAvatares();
        model.addAttribute("avatares", avatares);
        return "avatar/listaAvatares";
   }

    @RequestMapping("/showForm")
    public String showFormAvatar(Model model) {
        List<Aluno> alunosSemAvatar = alunoService.getAlunosSemAvatar();
        Avatar avatar = new Avatar();
        model.addAttribute("avatar", avatar);
        model.addAttribute("alunosSemAvatar", alunosSemAvatar);
        return "avatar/formAvatar";
    }

    @RequestMapping("/addAvatar")
    public String addAvatar(@ModelAttribute("avatar") Avatar avatar, @RequestParam("alunoId") Integer alunoId, Model model) {
        Aluno aluno = alunoService.getAlunoById(alunoId);
        avatar.setAluno(aluno);
        avatarService.salvarAvatar(avatar);
        model.addAttribute("avatar", avatar);
        aluno.setAvatar(avatar);
        alunoService.salvarAluno(aluno);
        return "avatar/paginaAvatar";
    }
}
