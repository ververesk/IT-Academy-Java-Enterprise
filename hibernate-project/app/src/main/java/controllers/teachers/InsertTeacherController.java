package controllers.teachers;




import org.grigorovich.model.Teacher;
import repositories.RepositoryFactory;
import repositories.TeacherRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createTeacher")
public class InsertTeacherController extends HttpServlet {
    private final TeacherRepository repository = RepositoryFactory.getTeacherRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/teacherInsertView.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = (String) request.getParameter("name");
            String surname = (String) request.getParameter("surname");
            int salary = Integer.parseInt(request.getParameter("salary"));
            Integer courseId = Integer.parseInt(request.getParameter("courseId"));
            String username = (String) request.getParameter("username");
      //      Teacher teacher = new Teacher(name, surname, salary, courseId, username);
     //       repository.insert(teacher);
            response.sendRedirect(request.getContextPath() + "/teacherList");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/WEB-INF/view/teacherInsertView.jsp").forward(request, response);
        }
    }
}


