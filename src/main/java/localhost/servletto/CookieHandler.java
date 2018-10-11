package localhost.servletto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CookieHandler {
    static void increment(HttpServletRequest req, HttpServletResponse resp, String cookieName) {
        String val = get(req, cookieName);
        if (val != null) {
            resp.addCookie(new Cookie(cookieName, "" + (Integer.parseInt(val) + 1)));
        } else {
            resp.addCookie(new Cookie(cookieName, "1"));
        }
    }

    static String get(HttpServletRequest req, String cookieName) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return (cookie.getValue());
                }
            }
        }
        return null;
    }
}
