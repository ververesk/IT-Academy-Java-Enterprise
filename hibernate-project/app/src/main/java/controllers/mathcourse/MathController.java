package controllers.mathcourse;

import org.grigorovich.model.MathCourse;
import org.grigorovich.model.Student;
import repositories.MathRepository;
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

@WebServlet(urlPatterns = {"/mathCourses"})
public class MathController extends HttpServlet {
    private final MathRepository repository = RepositoryFactory.getMathRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MathCourse> mathCourses = repository.findAll();
        request.setAttribute("mathCourses", mathCourses);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/view/MathCourseView.jsp");
        dispatcher.forward(request, response);
    }
}
