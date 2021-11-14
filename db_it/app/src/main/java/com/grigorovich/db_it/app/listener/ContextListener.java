package com.grigorovich.db_it.app.listener;

import com.grigirovich.db_it.model.User;
import com.grigirovich.db_it.model.UserDAO;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

import static com.grigirovich.db_it.model.User.ROLE.ADMIN;
import static com.grigirovich.db_it.model.User.ROLE.TEACHER;
import static com.grigirovich.db_it.model.User.ROLE.USER;


@WebListener
public class ContextListener implements ServletContextListener {

    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "Veronika", "1", ADMIN));
        dao.get().add(new User(2, "Slava", "1", USER));
        dao.get().add(new User(3, "Igor", "1", TEACHER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}