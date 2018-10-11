package localhost.servletto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doClick(req, resp, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doClick(req, resp, "POST");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doClick(req, resp, "PUT");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doClick(req, resp, "DELETE");
    }

    private void doClick(HttpServletRequest req, HttpServletResponse resp, String responceText) throws IOException {
        CookieHandler.increment(req, resp, "clicks");
        resp.setHeader("Content-type", "text/html");
        resp.getWriter().write(responceText + ", total clicks - " + CookieHandler.get(req, "clicks"));
    }
}
