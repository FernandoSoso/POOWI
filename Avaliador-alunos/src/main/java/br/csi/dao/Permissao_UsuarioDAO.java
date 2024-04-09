package br.csi.dao;

import br.csi.model.Permissao_Usuario;
import br.csi.util.ConectaDBPostgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Permissao_UsuarioDAO {
    public ArrayList<Permissao_Usuario> getPermissoes_Usuario() {
        ArrayList<Permissao_Usuario> permissoes_usuario = new ArrayList<>();
        Connection conn = new ConectaDBPostgres().getConexao();
        try {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM permissao_usuario");

            while (rs.next()) {
                Permissao_Usuario pu = new Permissao_Usuario(
                        rs.getInt("cod_usuario"),
                        rs.getInt("cod_permissao")
                );
                permissoes_usuario.add(pu);
            }

            return permissoes_usuario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}