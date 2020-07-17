package modelo;

import java.sql.Date;

public class Aula {

    private int Codigo, NroSala;
    private String RG, Descricao;
    private Date DataHora;

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getNroSala() {
        return NroSala;
    }

    public void setNroSala(int NroSala) {
        this.NroSala = NroSala;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getDataHora() {
        return DataHora;
    }

    public void setDataHora(Date DataHora) {
        this.DataHora = DataHora;
    }

}