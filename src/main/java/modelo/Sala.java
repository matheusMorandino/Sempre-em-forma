package modelo;

public class Sala {

    private int NroSala;
    private float Area;
    private String Localizacao;
    private char TipoSala;
    
    public Sala(int NroSala)
    {
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

    public char getTipoSala() {
        return TipoSala;
    }

    public void setTipoSala(char TipoSala) {
        this.TipoSala = TipoSala;
    }

}