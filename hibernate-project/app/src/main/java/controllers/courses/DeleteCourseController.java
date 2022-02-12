package controllers.courses;

import repositories.CourseRepository;
import repositories.RepositoryFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCourse")
public class DeleteCourseController extends HttpServlet {
    private final CourseRepository repository = RepositoryFactory.getCourseRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            repository.remove(courseId);
            response.sendRedirect(request.getContextPath() + "/courseList");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
        }
    }
}



