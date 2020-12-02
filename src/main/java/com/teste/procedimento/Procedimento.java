package com.teste.procedimento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Procedimento {

    @Id
    private Integer cdProcedimento;
    private Integer idade;
    private String sexo;
    private String permitido;

    public Procedimento() {
    }

    public Procedimento(Integer cdProcedimento, Integer idade, String sexo, String permitido) {
        this.cdProcedimento = cdProcedimento;
        this.idade = idade;
        this.sexo = sexo;
        this.permitido = permitido;
    }

    public Integer getCdProcedimento() {
        return cdProcedimento;
    }

    public void setCdProcedimento(Integer cdProcedimento) {
        this.cdProcedimento = cdProcedimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPermitido() {
        return permitido;
    }

    public void setPermitido(String permitido) {
        this.permitido = permitido;
    }
}

