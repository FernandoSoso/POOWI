package br.csi.model;

import br.csi.dao.PermissaoDAO;
import br.csi.dao.Permissao_UsuarioDAO;
import br.csi.dao.UsuarioDAO;

import java.util.ArrayList;

public class Permissao_Usuario {
    private int id_usuario;
    private int id_permissao;
    
    public Permissao_Usuario(int id_usuario, int id_permissao) {
        this.id_usuario = id_usuario;
        this.id_permissao = id_permissao;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }
    
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public int getId_permissao() {
        return id_permissao;
    }
    
    public void setId_permissao(int id_permissao) {
        this.id_permissao = id_permissao;
    }
    
    @Override
    public String toString() {
        return  "\nID do usuário: " + id_usuario + "\nID da permissão: " + id_permissao;
    }

    public static void mapearPermissaoUsuario(ArrayList<Usuario> usuarios){
        ArrayList<Permissao_Usuario> permissoes_usuario = new Permissao_UsuarioDAO().getPermissoes_Usuario();
        ArrayList<Permissao> permissoes = new PermissaoDAO().getPermissoes();

        for(Permissao_Usuario pu : permissoes_usuario){
            permissoes.forEach(permissao -> {
                if(permissao.getId() == pu.id_permissao){
                    usuarios.forEach(usuario -> {
                        if(usuario.getId() == pu.id_usuario){
                            ArrayList<Permissao> ap =  usuario.getPermissoes();
                            ap.add(permissao);
                            usuario.setPermissoes(ap);
                        }
                    });
                }
            });
        }
    }
}
