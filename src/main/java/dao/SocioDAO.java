/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;
import modelo.Socio;

/**
 *
 * @author jose luiz
 */
public class SocioDAO {
    
    private final Connection conexao;
    
    public SocioDAO() throws SQLException
    {
        conexao = FabricaConexao.getConnection();
    }
    
    public ArrayList<Socio> listarSocios() throws SQLException
    {
        ArrayList<Socio> socios = new ArrayList<>();
        
        String query = "SELECT * FROM socio ";
        
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(query);
        
        while(rs.next()) {
            Socio socio = new Socio(rs.getInt("NroSocio"), rs.getString("Nome"), rs.getString("Telefone"), rs.getString("Endereco"), rs.getString("Profissao"), rs.getString("DocBancarios"));
            socios.add(socio);
        }
        
        stm.close();
        rs.close();
        
        return socios;
    }
    
    public void inserirSocio(Socio socio) throws SQLException
    {
        String query = "insert into socio (NroSocio, Nome, Telefone, Endereco, Profissao, DocBancarios) \n" +
                        "values (" + socio.getNroSocio() + ", '" + socio.getNome() + "', '" + socio.getTelefone() + "', '" + socio.getEndereco() + "', '" + socio.getProfissao() + "', '" + socio.getDocBancarios() + "') \n" +
                        "on duplicate key \n" +
                        "update Nome='" + socio.getNome() + "', Telefone='" + socio.getTelefone() + "', Endereco='" + socio.getEndereco() + "', Profissao='" + socio.getProfissao() + "', DocBancarios='" + socio.getDocBancarios() + "'";
        
        Statement stm = conexao.createStatement();
        stm.executeUpdate(query);
        stm.close();
    }
    public void deletarSocio(Socio socio) throws SQLException
    {
        String query = "delete from socio where NroSocio = '" + socio.getNroSocio() +"'";
        
        Statement stm = conexao.createStatement();
        stm.executeUpdate(query);
        stm.close();
    }    
}
