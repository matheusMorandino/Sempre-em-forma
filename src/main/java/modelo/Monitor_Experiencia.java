/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author acere
 */
public class Monitor_Experiencia {
    
    private String RG, Nome, Telefone, Titulacao, Exp_Prof;
    private int CodExpProf;

    public Monitor_Experiencia(String RG, String Nome, String Telefone, String Titulacao, String Exp_Prof, int CodExpProf) {
        this.RG = RG;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Titulacao = Titulacao;
        this.Exp_Prof = Exp_Prof;
        this.CodExpProf = CodExpProf;
    }
    
    public Monitor_Experiencia(String RG)
    {
        this.RG = RG;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getTitulacao() {
        return Titulacao;
    }

    public void setTitulacao(String Titulacao) {
        this.Titulacao = Titulacao;
    }

    public String getExp_Prof() {
        return Exp_Prof;
    }

    public void setExp_Prof(String Exp_Prof) {
        this.Exp_Prof = Exp_Prof;
    }

    public int getCodExpProf() {
        return CodExpProf;
    }

    public void setCodExpProf(int CodExpProf) {
        this.CodExpProf = CodExpProf;
    }
    
}
