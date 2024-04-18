package br.csi.controller;




import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("usuario")
public class UsuarioServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Get para servlet USÁRIO");

        UsuarioDAO dao = new UsuarioDAO();


        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>LISTA DE USUÁRIOS </h1>");
        for(Usuario u : dao.getUsuarios()){
            out.println("<h3>");
            out.println("ID: "+u.getId());
            out.println("Nome: "+u.getNome());
            out.println("Nome: "+u.getEmail());
            out.println("</h3>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
