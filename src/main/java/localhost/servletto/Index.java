package localhost.servletto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieHandler.increment(req, resp, "visits");
        req.setAttribute("attr", CookieHandler.get(req, "visits"));
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }
}
