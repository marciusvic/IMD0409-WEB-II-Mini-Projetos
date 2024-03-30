package com.jeanlima.springmvcdatajpaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanlima.springmvcdatajpaapp.model.Avatar;
import com.jeanlima.springmvcdatajpaapp.repository.AvatarRepository;

@Service
public class AvatarServiceImpl implements AvatarService {

    @Autowired
    AvatarRepository avatarRepository;

    @Override
    public List<Avatar> getAvatares(){
        return avatarRepository.findAll();
    }

    @Override
    public void salvarAvatar(Avatar avatar){
        avatarRepository.save(avatar);
    }
    
}
