package br.csi.controller;

import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;
import br.csi.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("usuarios")
public class UsuarioServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UsuarioDAO dao = new UsuarioDAO();

        String opcao = req.getParameter("opcao");

        if (opcao != null){
            if (opcao.equals("Excluir")){
                int id = Integer.parseInt(req.getParameter("id"));

                if (new UsuarioService().excluir(id)){
                    req.setAttribute("retorno", "Cadastro excluido!");
                }
                else{
                    req.setAttribute("retorno", "Erro ao excluir!");
                }
            }
            else if (opcao.equals("Editar")){
                int id = Integer.parseInt(req.getParameter("id"));


            }
        }

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/usuarios.jsp");
        rd.forward(req, resp);

//        PrintWriter out = resp.getWriter();
//        out.println("<html>");
//        out.println("<body>");
//        out.println("<h1>LISTA DE USUÁRIOS </h1>");
//        for(Usuario u : dao.getUsuarios()){
//            out.println("<h3>");
//            out.println("ID: "+u.getId());
//            out.println("Nome: "+u.getNome());
//            out.println("Nome: "+u.getEmail());
//            out.println("</h3>");
//        }
//        out.println("</body>");
//        out.println("</html>");
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario u = new Usuario(nome, email, senha);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/usuarios.jsp");


        if (new UsuarioService().inserir(u)){
            req.setAttribute("retorno", "Cadastro efetuado!");
        }
        else{
            req.setAttribute("retorno", "Erro ao cadastrar!");
        }

        rd.forward(req, resp);
    }
}
