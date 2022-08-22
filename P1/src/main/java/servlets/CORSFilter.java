package servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter implements Filter {


    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }


    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }


    @Override
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("CORSFilter HTTP Request: " + request.getMethod());

        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "null");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","POST");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers","*");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Credentials","true");

        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (request.getMethod().equals("OPTIONS")) {
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }

        chain.doFilter(request, servletResponse);
    }
}
