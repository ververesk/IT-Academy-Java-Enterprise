package controllers.students;

import lombok.extern.slf4j.Slf4j;
import org.grigorovich.model.Student;
import repositories.RepositoryFactory;
import repositories.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@Slf4j
@WebServlet(urlPatterns = {"/updateStudent"})
public class UpdateStudentController extends HttpServlet {
    private final StudentRepository repository = RepositoryFactory.getStudentRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = repository.find(id);
        if (student != null) {
            request.setAttribute("student", student);
            getServletContext().getRequestDispatcher("/WEB-INF/view/studentUpdateView.jsp").forward(request, response);
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
        int age = Integer.parseInt(request.getParameter("age"));
        String username = (String) request.getParameter("username");
        Student student = new Student(id, name, surname, age, username);
        repository.update(student);
        response.sendRedirect(request.getContextPath() + "/studentList");
    }
}
