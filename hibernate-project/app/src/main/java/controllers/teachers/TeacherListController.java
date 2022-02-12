package controllers.teachers;


import org.grigorovich.model.Teacher;
import repositories.RepositoryFactory;
import repositories.TeacherRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/teacherList"})
public class TeacherListController extends HttpServlet {
    private final TeacherRepository repository = RepositoryFactory.getTeacherRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Teacher> teacherList = repository.findAll();
        request.setAttribute("teachers", teacherList);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/view/teachersListView.jsp");
        dispatcher.forward(request, response);
    }
}


