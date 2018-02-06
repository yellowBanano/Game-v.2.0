package by.myself.servlets;

import by.myself.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/start")
public class InitialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", UserService.getInstance().getUser());
        req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp")
                .forward(req, resp);
    }
}
