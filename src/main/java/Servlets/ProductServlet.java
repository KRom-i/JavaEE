package Servlets;

import Products.ProductArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Products", urlPatterns = "/products")
public class ProductServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(BasicServlet.class);

    private transient ServletConfig servletConfig;

    public void init (ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    public ServletConfig getServletConfig () {
        return servletConfig;
    }

    public void service (ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");
        servletResponse.getWriter().println(new ProductArray().getHtmlString());
    }

    public String getServletInfo () {
        return "Products";
    }

    public void destroy () {
        logger.info("Servlet {} destroy", getServletInfo());
    }

}
