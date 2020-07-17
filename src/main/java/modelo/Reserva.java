package modelo;

import java.util.Date;

public class Reserva {

    private int NroSocio, NroSala;
    private Date DataReserva;

    public Reserva(int NroSocio, int NroSala, Date DataReserva) {
        this.NroSocio = NroSocio;
        this.NroSala = NroSala;
        this.DataReserva = DataReserva;
    }
    
    public Reserva(int NroSala, Date DataReserva) {
        this.NroSala = NroSala;
        this.DataReserva = DataReserva;
    }
    
    public Reserva(Date DataReserva) {
        this.DataReserva = DataReserva;
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