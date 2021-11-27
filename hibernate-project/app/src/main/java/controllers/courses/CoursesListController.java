package controllers.courses;


import org.grigorovich.model.Course;
import repositories.CourseRepository;
import repositories.RepositoryFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/courseList"})
public class CoursesListController extends HttpServlet {

    private final CourseRepository repository = RepositoryFactory.getCourseRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Course> courseList = repository.findAll();
        request.setAttribute("courses", courseList);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/view/coursesListView.jsp");
        dispatcher.forward(request, response);
    }
}



