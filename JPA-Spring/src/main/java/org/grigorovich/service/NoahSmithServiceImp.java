package org.grigorovich.service;

import org.grigorovich.model.NoahSmith;
import org.grigorovich.repositories.NoahSmithRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoahSmithServiceImp implements NoahSmithService {

    @Autowired
    private NoahSmithRepositoryJPA noahSmithRepositoryJPA;

    @Override
    @Transactional
    public List<NoahSmith> getAllInfo() {
        return noahSmithRepositoryJPA.findAll();
    }
}

