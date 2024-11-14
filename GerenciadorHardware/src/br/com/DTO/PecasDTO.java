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
public class PecasDTO {
    
     private int id;
    private String nome_pecas;
    
    public int getIdUsuario() {
        return id;
    }

    public void setIdUsuario(int id) {
        this.id = id;
    }
    public String getNomePecas() {
        return nome_pecas;
    }

    public void setNomePecas(String nome_pecas) {
        this.nome_pecas = nome_pecas;
    }
}
