package controllers.teachers;


import lombok.extern.slf4j.Slf4j;
import org.grigorovich.model.Teacher;
import repositories.RepositoryFactory;
import repositories.TeacherRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = {"/updateTeacher"})
public class UpdateTeacherController extends HttpServlet {
    private final TeacherRepository repository = RepositoryFactory.getTeacherRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Teacher teacher = repository.find(id);
        if (teacher !=null) {
            request.setAttribute("teacher", teacher);
            getServletContext().getRequestDispatcher("/WEB-INF/view/teacherUpdateView.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = (String) request.getParameter("name");
        String surname = (String) request.getParameter("surname");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String username = (String) request.getParameter("username");
        Teacher teacher = new Teacher(id, name, surname, salary, username);
        repository.update(teacher);
        response.sendRedirect(request.getContextPath() + "/teacherList");
    }
}

