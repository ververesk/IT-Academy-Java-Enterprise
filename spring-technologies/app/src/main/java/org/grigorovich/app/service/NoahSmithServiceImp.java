package org.grigorovich.app.service;

import org.grigorovich.app.repositories.AbstractRepository;
import org.grigorovich.model.NoahSmith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class NoahSmithServiceImp implements EntityService<NoahSmith>{

    @Qualifier("noahSmithRepositoryJPA")
    @Autowired
    private AbstractRepository abstractRepository;
    @Override
    @Transactional
    public List<NoahSmith> getAll() {
        return abstractRepository.getAll();
    }

    @Override
    @Transactional
    public void saveEntity(NoahSmith entity) {

    }

    @Override
    @Transactional
    public NoahSmith getEntity(int id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {

    }
}
