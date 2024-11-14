/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DTO;


public class EquipamentoDTO {
    
    
    private int id, id_laboratorio;
    private String nome, processador, ram, armazenamento, numero_serie, data_aquisicao;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(String data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }
    
   

}