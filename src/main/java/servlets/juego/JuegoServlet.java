package servlets.juego;

import org.omg.Messaging.SyncScopeHelper;
import server.server.controlador.EmpresasControlador;
import server.server.controlador.GeneroControlador;
import server.server.controlador.JuegosControlador;
import server.server.dao.JuegosDao;
import server.server.dto.EmpresasDto;
import server.server.dto.GeneroDto;
import server.server.dto.JuegosDto;
import server.server.estructura.stack.IStackArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/juego.do")
public class JuegoServlet extends HttpServlet {

    private final JuegosControlador juegosControlador = new JuegosControlador();
    private final EmpresasControlador empresasControlador = new EmpresasControlador();
    private final GeneroControlador generoControlador = new GeneroControlador();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        if (title == null) {
            req.setAttribute("title", "Add Juegos");
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
        String description = req.getParameter("description");

        String releaseDate = req.getParameter("releaseDate");
        System.out.println(releaseDate);
        Date dateToDataBase = Date.valueOf(releaseDate);
        System.out.println(dateToDataBase.toString());
        Double calification = Double.parseDouble(req.getParameter("calification"));

        int empresa = Integer.parseInt(req.getParameter("empresa"));

        int genero = Integer.parseInt(req.getParameter("genero"));

        if (action.equals("Update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            juegosControlador.update(id,name,description,dateToDataBase,calification,empresa,genero);
        } else {
            juegosControlador.insert(name,description,dateToDataBase,calification,empresa,genero);
        }
        req.setAttribute("title", "Add Juegos");
        list(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 7;
        if(req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        try {
            IStackArray<JuegosDto> juegosStack = juegosControlador.findAll();
            int noOfRecords = juegosStack.size();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            ArrayList<JuegosDto> juegosDto = juegosStack.hacerArrayList();
            ArrayList<VistaJuego> juegos = VistaJuego.pasarJuegos(juegosDto);

            ArrayList<EmpresasDto> empresas = empresasControlador.findAll().hacerArrayList();
            req.setAttribute("empresas", empresas);

            ArrayList<GeneroDto> generos = generoControlador.findAll().hacerArrayList();
            req.setAttribute("generos", generos);

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
        JuegosDto juegodto = juegosControlador.findById(id);
        req.setAttribute("juego", juegodto);

        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Add Juegos");
        int id = Integer.parseInt(req.getParameter("value"));
        JuegosDto juego = new JuegosDto();
        juego.setId(id);
        juegosControlador.delete(id);
        req.setAttribute("juego", juego);
        list(req, resp);
    }
}
