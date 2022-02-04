package org.grigorovich.service;

import org.grigorovich.app.repositories.InfoAboutTeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfoAboutTeacherServiceImp implements TeacherService{

    @Autowired
    private InfoAboutTeachersRepository teachersRepository;

    @Override
    @Transactional
    public String avgTeacherSalary() {
       return teachersRepository.avgTeacherSalary();
    }

    @Override
    @Transactional
    public Long sumTeacherSalary() {
        return teachersRepository.sumTeacherSalary();
    }
}
