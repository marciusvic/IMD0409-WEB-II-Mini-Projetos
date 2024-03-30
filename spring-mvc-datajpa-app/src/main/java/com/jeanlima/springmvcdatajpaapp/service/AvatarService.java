package com.jeanlima.springmvcdatajpaapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.jeanlima.springmvcdatajpaapp.model.Avatar;

@Service
public interface AvatarService {

    public List<Avatar> getAvatares();
    public void salvarAvatar(Avatar avatar);
    
}
