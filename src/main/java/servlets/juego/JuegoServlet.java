package servlets.juego;

import org.omg.Messaging.SyncScopeHelper;
import server.server.dao.JuegosDao;
import server.server.dto.JuegosDto;
import server.server.estructura.stack.IStackArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/juego.do")
public class JuegoServlet extends HttpServlet {

    private final JuegosDao juegoDao = new JuegosDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al doGet");
        String title = req.getParameter("title");
        if (title == null) {
            req.setAttribute("title", "Add Juegos");
        }
        System.out.println("Despues de ajustar el titulo");
        String action = req.getParameter("action");
        System.out.println("Acción: "+ action);
        switch (req.getParameter("action")) {
            case "Listar":
                System.out.println("Case Listar");
                list(req, resp);
                break;
            case "Update":
                update(req, resp);
                break;
            case "Delete":
                delete(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        JuegosDto juego = new JuegosDto();
        juego.setName(req.getParameter("name"));
        if (action.equals("Update")) {
            System.out.println(req.getParameter("id") + " y" + juego.getName());
            juego.setId(Integer.parseInt(req.getParameter("id")));
            juegoDao.update(juego);
        } else {
            juegoDao.insert(juego);
        }
        req.setAttribute("title", "Add Juegos");
        list(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al metodo list");
        int page = 1;
        int recordsPerPage = 7;
        if(req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
            System.out.println("El numero de la pagina es: "+ page);
        }
        try {
            System.out.println("Entró al bloque try");
            IStackArray<JuegosDto> juegosStack = juegoDao.findAll(new JuegosDto());
            int noOfRecords = juegosStack.size();
            System.out.println("Número de elementos: "+ noOfRecords);
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

            ArrayList<JuegosDto> juegos = juegosStack.hacerArrayList();
            req.setAttribute("juegos", juegos);
            req.setAttribute("noOfPages", noOfPages);
            req.setAttribute("currentPage", page);
            req.getRequestDispatcher("/WEB-INF/views/juego/juego.jsp").forward(req, resp);
        } catch (Exception throwables) {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("title", "Update Juegos");
        int id = Integer.parseInt(req.getParameter("value"));
        JuegosDto juegoConId = new JuegosDto();
        juegoConId.setId(id);
        JuegosDto juegodto = (JuegosDto)juegoDao.findById((juegoConId));
        req.setAttribute("juego", juegodto);

        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Add Juegos");
        int id = Integer.parseInt(req.getParameter("value"));
        JuegosDto juego = new JuegosDto();
        juego.setId(id);
        juegoDao.delete(juego);
        req.setAttribute("juego", juego);
        list(req, resp);
    }
}
