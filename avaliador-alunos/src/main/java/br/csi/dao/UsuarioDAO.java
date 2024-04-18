package br.csi.dao;

import br.csi.model.Usuario;
import br.csi.util.ConectaDBPostgres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public Usuario getUsuarioByAuth(String email, String senha){
        try{
            ConectaDBPostgres cdb = new ConectaDBPostgres();
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
            return null;
        }
    }

    public boolean insertUsuario(Usuario usuario){
        try {
            ConectaDBPostgres cdb = new ConectaDBPostgres();

            Statement stmt = cdb.getConexao().createStatement();
            String sql =
                    "INSERT INTO usuario(nome, email, senha, data_cadastro, ativo) " +
                    "VALUES ('" + usuario.getNome() + "', '" + usuario.getEmail() + "', '" + usuario.getSenha() + "'" +
                    ", current_date, true)";

            stmt.execute(sql);

            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
