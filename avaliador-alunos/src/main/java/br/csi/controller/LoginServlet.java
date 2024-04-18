package br.csi.controller;

import br.csi.service.LoginService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");


       if(new LoginService().logar(email, senha)){

           RequestDispatcher rd =
                   req.getRequestDispatcher("WEB-INF/pages/dashboard.jsp");
           rd.forward(req, resp);

       }else{
           RequestDispatcher rd =
                   req.getRequestDispatcher("index.jsp");
           req.setAttribute("erro", "USUÁRIO OU SENHA INCORRETOS");
           rd.forward(req, resp);
       }

    }
}
