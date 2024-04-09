package br.csi.model;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private boolean ativo;

    private ArrayList<Permissao> permissoes;

    public Usuario(int id, String nome, String email, String senha, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.permissoes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public ArrayList<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(ArrayList<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder("\nID: " + id + "\nNome: " + nome + "\nE-mail: " + email + "\nSenha: " + senha + "\nStatus: " + ativo);
        for(Permissao permissao : permissoes){
            retorno.append("\nPermissão: ").append(permissao.getNome());
        }
        return retorno.toString();
    }
}
