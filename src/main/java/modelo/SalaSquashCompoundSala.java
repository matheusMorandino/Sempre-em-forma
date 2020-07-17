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
public class SalaSquashCompoundSala {
 
    private int NroSala;
    private float Area;
    private String Localizacao;
    private String Estado;

    public SalaSquashCompoundSala(int NroSala, float Area, String Localizacao, String Estado) {
        this.NroSala = NroSala;
        this.Area = Area;
        this.Localizacao = Localizacao;
        this.Estado = Estado;
    }
    
    public SalaSquashCompoundSala(int NroSala) {
        this.NroSala = NroSala;
    }
    
    public int getNroSala() {
        return NroSala;
    }

    public void setNroSala(int NroSala) {
        this.NroSala = NroSala;
    }

    public float getArea() {
        return Area;
    }

    public void setArea(float Area) {
        this.Area = Area;
    }

    public String getLocalizacao() {
        return Localizacao;
    }

    public void setLocalizacao(String Localizacao) {
        this.Localizacao = Localizacao;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
