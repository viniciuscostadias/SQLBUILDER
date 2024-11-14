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
public class LaboratorioDTO {
     private int id;
    private String nome_laboratorio;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNomeLab() {
        return nome_laboratorio;
    }

    public void setNomeLab(String nome_laboratorio) {
        this.nome_laboratorio = nome_laboratorio;
    }
}
