package servlets.vehiclesbrands;

import model.vehiclesbrands.VehiclesBrand;
import model.vehiclesbrands.VehiclesBrandDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/vehiclesbrands.do")
public class VehiclesBrandsServlet extends HttpServlet {

    private final VehiclesBrandDao brandDao = new VehiclesBrandDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        if (title == null) {
            req.setAttribute("title", "List Brands");
        }

        String action = req.getParameter("action");
        switch (req.getParameter("action")) {
            case "Listar":
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
        VehiclesBrand vehiclesBrand = new VehiclesBrand();
        vehiclesBrand.setName(req.getParameter("name"));
        if (action.equals("Update")) {
            System.out.println(req.getParameter("id") + " y" + vehiclesBrand.getName());
            vehiclesBrand.setId(Integer.parseInt(req.getParameter("id")));
            brandDao.update(vehiclesBrand);
        } else {
            brandDao.insert(vehiclesBrand);
        }
        req.setAttribute("title", "List Brands");
        list(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 7;
        if(req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        try {
            int noOfRecords = brandDao.count();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

            ArrayList<VehiclesBrand> brands = (ArrayList<VehiclesBrand>) brandDao.getAll(recordsPerPage, ((page -1)* recordsPerPage));
            req.setAttribute("brands", brands);
            req.setAttribute("noOfPages", noOfPages);
            req.setAttribute("currentPage", page);
            req.getRequestDispatcher("/WEB-INF/views/brands/brands.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("title", "Update Brands");
            int id = Integer.parseInt(req.getParameter("value"));
            VehiclesBrand vehiclesBrand = brandDao.getById(new VehiclesBrand(id));
            req.setAttribute("brand", vehiclesBrand);
        } catch (SQLException throwables) {
        }
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "List Brands");
        int id = Integer.parseInt(req.getParameter("value"));
        VehiclesBrand vehiclesBrand = new VehiclesBrand(id);
        brandDao.delete(vehiclesBrand);
        req.setAttribute("brand", vehiclesBrand);
        list(req, resp);
    }
}
