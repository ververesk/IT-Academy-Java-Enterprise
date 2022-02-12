package org.grigorovich.repositories;

import org.grigorovich.model.NoahSmith;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Тут нам нужно только чтобы студент мог видеть список всех своих оценок и всё
 */

public interface NoahSmithRepositoryJPA extends JpaRepository<NoahSmith, Integer> {

}
