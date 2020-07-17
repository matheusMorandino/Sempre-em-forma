package modelo;

public class Monitor {

    private String RG, Nome, Telefone, Titulacao;

    public Monitor(String RG, String Nome, String Telefone, String Titulacao) {
        this.RG = RG;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Titulacao = Titulacao;
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
    
}