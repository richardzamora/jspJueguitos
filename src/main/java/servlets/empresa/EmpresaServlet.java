package servlets.empresa;

import org.omg.Messaging.SyncScopeHelper;
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

    private final EmpresasDao empresaDao = new EmpresasDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al doGet");
        String title = req.getParameter("title");
        if (title == null) {
            req.setAttribute("title", "Add Empresas");
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
        EmpresasDto empresa = new EmpresasDto();
        empresa.setName(req.getParameter("name"));
        if (action.equals("Update")) {
            System.out.println(req.getParameter("id") + " y" + empresa.getName());
            empresa.setId(Integer.parseInt(req.getParameter("id")));
            empresaDao.update(empresa);
        } else {
            empresaDao.insert(empresa);
        }
        req.setAttribute("title", "Add Empresas");
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
            IStackArray<EmpresasDto> empresasStack = empresaDao.findAll(new EmpresasDto());
            int noOfRecords = empresasStack.size();
            System.out.println("Número de elementos: "+ noOfRecords);
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
        EmpresasDto empresadto = (EmpresasDto)empresaDao.findById((empresaConId));
        req.setAttribute("empresa", empresadto);

        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Add Empresas");
        int id = Integer.parseInt(req.getParameter("value"));
        EmpresasDto empresa = new EmpresasDto();
        empresa.setId(id);
        empresaDao.delete(empresa);
        req.setAttribute("empresa", empresa);
        list(req, resp);
    }
}
