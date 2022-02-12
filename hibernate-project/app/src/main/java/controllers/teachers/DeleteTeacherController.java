package controllers.teachers;


import repositories.RepositoryFactory;
import repositories.TeacherRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTeacher")
public class DeleteTeacherController extends HttpServlet {
    private final TeacherRepository repository = RepositoryFactory.getTeacherRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            repository.remove(id);
            response.sendRedirect(request.getContextPath() + "/teacherList");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
        }
    }
}


