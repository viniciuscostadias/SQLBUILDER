/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DTO;

/**
 *
 * @author W10
 */
public class UsuarioDTO {
    
    private int id;
    private String nome, email, nome_usuario, senha;
    
    public int getIdUsuario() {
        return id;
    }

    public void setIdUsuario(int id) {
        this.id = id;
    }

    public String getEmailUsuario() {
        return email;
    }

    public void setEmailUsuario(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nome_usuario;
    }

    public void setNomeUsuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }
 public String getNomeUsuUsuario() {
        return nome;
    }

    public void setNomeUsuUsuario(String nome_usuario) {
        this.nome = nome;
    }
    public String getSenhaUsuario() {
        return senha;
    }

    public void setSenhaUsuario(String senha) {
        this.senha = senha;
    }
}

