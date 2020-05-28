package servlets.empresa;

import org.omg.Messaging.SyncScopeHelper;
import server.server.controlador.EmpresasControlador;
import server.server.dao.EmpresasDao;
import server.server.dto.EmpresasDto;
import server.server.estructura.stack.IStackArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/empresa.do")
public class EmpresaServlet extends HttpServlet {

    private final EmpresasControlador empresasControlador = new EmpresasControlador();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        if (title == null) {
            req.setAttribute("title", "Add Empresas");
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
           int id = Integer.parseInt(req.getParameter("id"));
            empresasControlador.update(id, name);
        } else {
            empresasControlador.insert(name);
        }
        req.setAttribute("title", "Add Empresas");
        list(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int page = 1;
        int recordsPerPage = 7;
        if(req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        try {
            IStackArray<EmpresasDto> empresasStack = empresasControlador.findAll();
            int noOfRecords = empresasStack.size();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

            ArrayList<EmpresasDto> empresas = empresasStack.hacerArrayList();
            req.setAttribute("empresas", empresas);
            req.setAttribute("noOfPages", noOfPages);
            req.setAttribute("currentPage", page);
            req.getRequestDispatcher("/WEB-INF/views/empresa/empresa.jsp").forward(req, resp);
        } catch (Exception throwables) {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("title", "Update Empresas");
        int id = Integer.parseInt(req.getParameter("value"));
        EmpresasDto empresaConId = new EmpresasDto();
        empresaConId.setId(id);
        EmpresasDto empresadto = empresasControlador.findById(id);
        req.setAttribute("empresa", empresadto);

        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Add Empresas");
        int id = Integer.parseInt(req.getParameter("value"));
        EmpresasDto empresa = new EmpresasDto();
        empresa.setId(id);
       empresasControlador.delete(id);
        req.setAttribute("empresa", empresa);
        list(req, resp);
    }
}
