package br.csi.dao;

import br.csi.model.Usuario;
import br.csi.util.ConectaDBPostgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection conn = new ConectaDBPostgres().getConexao();
        try{
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");

            while(rs.next()){
                Usuario u = new Usuario(
                        rs.getInt("cod"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo")
                );
                usuarios.add(u);
            }

            return usuarios;
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}

