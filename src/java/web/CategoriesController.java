package web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.CategoriesLogic;

public class CategoriesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view;
        String action = request.getParameter("action");
        view = request.getRequestDispatcher("Categories/index.jsp");        
        if (action != null) {
            switch (action) {
                case "new":
                    view = request.getRequestDispatcher("Categories/new.jsp");
                    break;
                case "delete":
                    CategoriesLogic.deleteCategory(Integer.parseInt(request.getParameter("id")));
                    break;
            }
        }
        view.forward(request, response);   
    }

    private String decode(String value) {
        try {
            return new String(value.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DefectsController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view;
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        view = request.getRequestDispatcher("Defects/index.jsp");        
        if (action != null) {
            if (action.equals("create")) {
                try {
                    CategoriesLogic.newCategory(
                            decode(request.getParameter("name"))
                            );
                } catch (Exception ex) {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print(String.format("<script language='javascript' type='text/javascript'>alert('%s');</script>", ex.getMessage()));
                    response.getWriter().print("<script language='javascript' type='text/javascript'>location.replace('/v22/categories?action=new')</script>");
                    return;
                }
                view = request.getRequestDispatcher("Categories/index.jsp");
            } 
        }
        view.forward(request, response);   
    }
}
