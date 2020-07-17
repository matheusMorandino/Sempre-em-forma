package modelo;

public class Socio {

    private int NroSocio;
    private String Nome, Telefone, Endereco, Profissao, DocBancarios;

    public Socio(int NroSocio, String Nome, String Telefone, String Endereco, String Profissao, String DocBancarios) {
        this.NroSocio = NroSocio;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Endereco = Endereco;
        this.Profissao = Profissao;
        this.DocBancarios = DocBancarios;
    }
    
    public Socio(int NroSocio) {
        this.NroSocio = NroSocio;
    }
    
    public Socio(String Nome) {
        this.Nome = Nome;
    }
    
    public int getNroSocio() {
        return NroSocio;
    }

    public void setNroSocio(int NroSocio) {
        this.NroSocio = NroSocio;
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

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getProfissao() {
        return Profissao;
    }

    public void setProfissao(String Profissao) {
        this.Profissao = Profissao;
    }

    public String getDocBancarios() {
        return DocBancarios;
    }

    public void setDocBancarios(String DocBancarios) {
        this.DocBancarios = DocBancarios;
    }

}