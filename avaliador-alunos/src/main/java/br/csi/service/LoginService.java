package br.csi.service;

import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;

public class LoginService {

    public boolean logar(String email, String senha){
        Usuario user = new UsuarioDAO().getUsuarioByAuth(email, senha);

        if (user == null){
            return false;
        }
        else{
            return true;
        }
    }


}
