package com.example.EsercizioBE_U2_W2_D2_BloggingApp.service;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.repository.AutoreDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoreService {
    @Autowired
    AutoreDAORepository autoreRepo;
}
