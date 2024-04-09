package br.csi.dao;

import br.csi.model.Permissao;
import br.csi.util.ConectaDBPostgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PermissaoDAO {
    public ArrayList<Permissao> getPermissoes() {
        ArrayList<Permissao> permissoes = new ArrayList<>();
        Connection conn = new ConectaDBPostgres().getConexao();
        try{
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM permissao");

            while(rs.next()){
                Permissao p = new Permissao(
                        rs.getInt("cod"),
                        rs.getString("nome")
                );
                permissoes.add(p);
            }

            return permissoes;
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
