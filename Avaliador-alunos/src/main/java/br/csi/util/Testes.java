package br.csi.util;

import br.csi.dao.PermissaoDAO;
import br.csi.dao.UsuarioDAO;
import br.csi.model.Permissao;
import br.csi.model.Permissao_Usuario;
import br.csi.model.Usuario;

import java.util.ArrayList;

public class Testes {
    public static void main(String[] args) {

        UsuarioDAO Udao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = Udao.getUsuarios();

        Permissao_Usuario.mapearPermissaoUsuario(usuarios);

        for(Usuario u : usuarios){
            System.out.println(u);
        }
    }
}
