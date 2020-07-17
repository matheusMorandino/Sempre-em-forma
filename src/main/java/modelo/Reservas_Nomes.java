/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author acere
 */
public class Reservas_Nomes {
    
    private String Nome;
    private int NroSocio, NroSala;
    private Date DataReserva;

    public Reservas_Nomes(String Nome, int NroSocio, int NroSala, Date DataReserva) {
        this.Nome = Nome;
        this.NroSocio = NroSocio;
        this.NroSala = NroSala;
        this.DataReserva = DataReserva;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getNroSocio() {
        return NroSocio;
    }

    public void setNroSocio(int NroSocio) {
        this.NroSocio = NroSocio;
    }

    public int getNroSala() {
        return NroSala;
    }

    public void setNroSala(int NroSala) {
        this.NroSala = NroSala;
    }

    public Date getDataReserva() {
        return DataReserva;
    }

    public void setDataReserva(Date DataReserva) {
        this.DataReserva = DataReserva;
    }
    
}
