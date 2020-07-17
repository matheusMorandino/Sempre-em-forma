package modelo;

public class SalaSquash {

    private int NroSala;
    private String Estado;

    public SalaSquash(int NroSala, String Estado) {
        this.NroSala = NroSala;
        this.Estado = Estado;
    }
    
    public SalaSquash(int NroSala) {
        this.NroSala = NroSala;
    }
    
    public int getNroSala() {
        return NroSala;
    }

    public void setNroSala(int NroSala) {
        this.NroSala = NroSala;
    }
   
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
 
}