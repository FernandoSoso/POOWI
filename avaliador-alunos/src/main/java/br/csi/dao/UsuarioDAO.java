package br.csi.dao;

import br.csi.model.Usuario;
import br.csi.util.ConectaDBPostgres;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Dictionary;

public class UsuarioDAO {

    public ArrayList<Usuario> getUsuarios(){

        ConectaDBPostgres cdb = new ConectaDBPostgres();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            Statement stmt = cdb.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()){
                Usuario u =
                        new Usuario(
                                rs.getInt("cod"),
                                rs.getString("nome"),
                                rs.getString("email"),
                                rs.getString("senha"),
                                rs.getBoolean("ativo"));
                usuarios.add(u);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario getUsuario(String email, String senha){
        ConectaDBPostgres cdb = new ConectaDBPostgres();

        try{
            Statement stmt = cdb.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE email = '" + email + "' AND senha = '" + senha + "'");


            if (!rs.next()){
                return null;
            }
            else{

                Usuario usuario = new Usuario(
                        rs.getInt("cod"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo")
                );

                return usuario;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}