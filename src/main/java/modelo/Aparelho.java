package modelo;

public class Aparelho {

    private int CodAparelho, NroSala;
    private String Descricao, Estado;

    public int getCodAparelho() {
        return CodAparelho;
    }

    public void setCodAparelho(int CodAparelho) {
        this.CodAparelho = CodAparelho;
    }

    public int getNroSala() {
        return NroSala;
    }

    public void setNroSala(int NroSala) {
        this.NroSala = NroSala;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}