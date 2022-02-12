package controllers;

import org.grigorovich.model.MathCourse;
import org.grigorovich.model.NoahSmith;
import repositories.MathRepository;
import repositories.NoahSmithRepository;
import repositories.RepositoryFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/NoahSmith")
public class NoahSmithController extends HttpServlet {
    private final NoahSmithRepository repository = RepositoryFactory.getNoahSmithRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<NoahSmith> noahSmith = repository.findAll();
        request.setAttribute("noahSmith", noahSmith);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/view/NoahSmithView.jsp");
        dispatcher.forward(request, response);
    }
}
