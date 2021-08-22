import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "BasicServlet", urlPatterns = "/basic_servlet")
public class BasicServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(BasicServlet.class);

//    transient - переходящий
    private transient ServletConfig servletConfig;


//    Метод вызывается контейнером после того как был создан класс сервлета
//    The method is called by the container after the servlet class has been created

    public void init (ServletConfig servletConfig) throws ServletException {
        // Сохраняем полученную от сервера конфигурацию
        // We save the configuration received from the server
        this.servletConfig = servletConfig;
    }

    public ServletConfig getServletConfig () {
        return servletConfig;
    }

//    Метод вызывается для каждого нового HTTP запроса к данному сервлету
//    The method is called for each new HTTP request to this servlet
    public void service (ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");

        // получает объект типа BufferWriter и пишем в него ответ на пришедший запрос
        // gets an object of type BufferWriter adn write a response to the incoming request into it

        servletResponse.getWriter().println("<h1>Servlet content</h1> \n <h2>Servlet content</h2> \n <h3>Servlet content</h3> \n<h4>Servlet content</h4>");
    }

    public String getServletInfo () {
        return "BasicServlet";
    }

//    При завершении работы приложения, контейнер вызывает этот метод для всех сервлетов из этого приложения
//    When the application exits, the container calls this method for all servlet from that application
//    destroy - (Разрушать, уничтожать, сводить к нулю)
    public void destroy () {
        logger.info("Servlet {} destroy", getServletInfo());
    }
}
