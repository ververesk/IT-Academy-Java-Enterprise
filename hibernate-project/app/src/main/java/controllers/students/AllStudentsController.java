package controllers.students;

import org.grigorovich.model.Student;
import repositories.RepositoryFactory;
import repositories.StudentRepository;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/studentList"})
public class AllStudentsController extends HttpServlet {

    private final StudentRepository repository = RepositoryFactory.getStudentRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> studentList = repository.findAll();
        request.setAttribute("students", studentList);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/view/studentsListView.jsp");
        dispatcher.forward(request, response);
    }
}


