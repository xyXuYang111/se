package com.xuyang.work.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class CookieFilter
 * 解决 Cookie未设置HttpOnly  &&  Cookie未设置Secure标识  问题
 * @author xiaheshun
 */
@WebFilter(filterName = "cookieFilter", urlPatterns = "/*")
public class CookieFilter implements Filter {

    /**
     * Default constructor.
     */
    public CookieFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String value = cookie.getValue();
                StringBuilder builder = new StringBuilder();
                builder.append(cookie.getName() + "=" + value + ";");
                builder.append("Secure;");//Cookie设置Secure标识
                builder.append("HttpOnly;");//Cookie设置HttpOnly
                resp.addHeader("Set-Cookie", builder.toString());
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}

