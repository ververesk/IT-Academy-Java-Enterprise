package controllers.mathcourse;

import org.grigorovich.model.MathCourse;
import org.grigorovich.model.Student;
import repositories.MathRepository;
import repositories.RepositoryFactory;
import repositories.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/updateGrade"})
public class UpdateMathGradesController extends HttpServlet {
    private final MathRepository repository = RepositoryFactory.getMathRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MathCourse mathCourse = repository.find(id);
        if (mathCourse != null) {
            request.setAttribute("mathCourse", mathCourse);
            getServletContext().getRequestDispatcher("/WEB-INF/view/mathCourseUpdateView.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int grades = Integer.parseInt(request.getParameter("grades"));
        String studentName = (String) request.getParameter("studentName");
        MathCourse mathCourse = new MathCourse(id, grades, studentName);
        repository.update(mathCourse);
        response.sendRedirect(request.getContextPath() + "/mathCourses");
    }
}
