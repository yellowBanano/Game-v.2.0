package by.myself.servlets;


import by.myself.ProductService;
import by.myself.entities.Product;
import by.myself.utils.entities.Sort;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private static final long serialVersionUID = -2663213812763196874L;
    public static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    public static List<Product> PRODUCTS = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", PRODUCTS);
        int page = 1;
        int recordsPerPage = 50;
        int numberOfProducts = PRODUCTS.size();
        if (req.getParameter("pagination") != null) {
            recordsPerPage = Integer.parseInt(req.getParameter("pagination"));
        }
        int numberOfPages = (int) Math.ceil((double) numberOfProducts / recordsPerPage);
        if(req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));
        req.setAttribute("currentPage", page);
        req.setAttribute("numberOfPages", numberOfPages);
        req.getRequestDispatcher("/WEB-INF/jsp/search.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userQuery = req.getParameter("user-query");
        String limit = req.getParameter("limit");
        String offset = req.getParameter("offset");
        String sort = req.getParameter("sort");
        String pagination = req.getParameter("pagination");

        PRODUCTS.clear();

        Session session = SESSION_FACTORY.openSession();
        PRODUCTS = ProductService
                .getInstance()
                .getProductDao()
                .searchProducts(session, userQuery, Integer.valueOf(limit), Integer.valueOf(offset), Sort.valueOf(sort));
        session.close();

        doGet(req, resp);
    }
}
