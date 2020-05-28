package servlets.genero;

import org.omg.Messaging.SyncScopeHelper;
import server.server.controlador.GeneroControlador;
import server.server.dao.GeneroDao;
import server.server.dto.GeneroDto;
import server.server.estructura.stack.IStackArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/genero.do")
public class GeneroServlet extends HttpServlet {

    private final GeneroControlador generoControlador = new GeneroControlador();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al doGet");
        String title = req.getParameter("title");
        if (title == null) {
            req.setAttribute("title", "Add Generos");
        }
        String action = req.getParameter("action");
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

        String name = req.getParameter("name");
        if (action.equals("Update")) {
            int id =Integer.parseInt(req.getParameter("id"));
            generoControlador.update(id, name);
        } else {
            generoControlador.insert(name);
        }
        req.setAttribute("title", "Add Generos");
        list(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 7;
        if(req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        try {
            IStackArray<GeneroDto> generosStack = generoControlador.findAll();
            int noOfRecords = generosStack.size();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            ArrayList<GeneroDto> generos = generosStack.hacerArrayList();
            req.setAttribute("generos", generos);
            req.setAttribute("noOfPages", noOfPages);
            req.setAttribute("currentPage", page);
            req.getRequestDispatcher("/WEB-INF/views/genero/genero.jsp").forward(req, resp);
        } catch (Exception throwables) {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("title", "Update Generos");
        int id = Integer.parseInt(req.getParameter("value"));
        GeneroDto generodto = generoControlador.findById(id);
        req.setAttribute("genero", generodto);
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Add Generos");
        int id = Integer.parseInt(req.getParameter("value"));
        GeneroDto genero = new GeneroDto();
        genero.setId(id);
        generoControlador.delete(id);
        req.setAttribute("genero", genero);
        list(req, resp);
    }
}
