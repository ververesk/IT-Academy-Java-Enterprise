package controllers.teachers;

import repositories.RepositoryFactory;
import repositories.TeacherRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/sumSalary"})
public class TeacherSumController extends HttpServlet {

    private final TeacherRepository repository = RepositoryFactory.getTeacherRepository();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sumSalaries", repository.sumTeacherSalary());
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/WEB-INF/view/teachersSumSalaryView.jsp");
        dispatcher.forward(req, resp);
    }
}


