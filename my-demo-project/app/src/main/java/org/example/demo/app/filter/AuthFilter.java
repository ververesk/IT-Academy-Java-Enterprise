package org.example.demo.app.filter;

import org.example.demo.model.User;
import org.example.demo.model.dao.UserDAO;
import static java.util.Objects.nonNull;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class AuthFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(final ServletRequest request,
                             final ServletResponse response,
                             final FilterChain filterChain)

                throws IOException, ServletException {

            final HttpServletRequest req = (HttpServletRequest) request;
            final HttpServletResponse res = (HttpServletResponse) response;

            final String login = req.getParameter("login");
            final String password = req.getParameter("password");

            @SuppressWarnings("unchecked")
            final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

            final HttpSession session = req.getSession();

            //Logged user.
            if (nonNull(session) &&
                    nonNull(session.getAttribute("login")) &&
                    nonNull(session.getAttribute("password"))) {

                final User.ROLE role = (User.ROLE) session.getAttribute("role");

                moveToMenu(req, res, role);


            } else if (dao.get().userIsExist(login, password)) {

                final User.ROLE role = dao.get().getRoleByLoginPassword(login, password);

                req.getSession().setAttribute("password", password);
                req.getSession().setAttribute("login", login);
                req.getSession().setAttribute("role", role);

                moveToMenu(req, res, role);

            } else {

                moveToMenu(req, res, User.ROLE.UNKNOWN);
            }
        }


        private void moveToMenu(final HttpServletRequest req,
                                final HttpServletResponse res,
                                final User.ROLE role)
                throws ServletException, IOException {


            if (role.equals(User.ROLE.ADMIN)) {

                req.getRequestDispatcher("/WEB-INF/view/homePage.jsp").forward(req, res);

            } else if (role.equals(User.ROLE.USER)) {

                req.getRequestDispatcher("/WEB-INF/view/homePageForUser.jsp").forward(req, res);

            } else if (role.equals(User.ROLE.TEACHER)) {

                req.getRequestDispatcher("/WEB-INF/view/homePageForTeacher.jsp").forward(req, res);

            } else {

                req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);

            }
        }


        @Override
        public void destroy() {
        }

    }

