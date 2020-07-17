/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;
import modelo.SalaSquashCompoundSala;

/**
 *
 * @author jose luiz
 */
public class SalaSquashCompoundSalaDAO 
{
    private final Connection conexao;
    final char tipoSala = 's';
    
    public SalaSquashCompoundSalaDAO() throws SQLException
    {
        conexao = FabricaConexao.getConnection();
    }
    
    public ArrayList<SalaSquashCompoundSala> listarSalaSquash() throws SQLException
    {
        ArrayList<SalaSquashCompoundSala> salas = new ArrayList<>();
        
        String query = "select s.NroSala, s.Area, s.Localizacao, sq.Estado\n" +
                        "from sala s\n" +
                        "join salasquash sq\n" +
                        "on s.NroSala = sq.NroSala;";
        
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(query);
        
        while(rs.next()) {
                SalaSquashCompoundSala salaSquash = new SalaSquashCompoundSala(rs.getInt("NroSala"), rs.getFloat("Area"), rs.getString("Localizacao"), rs.getString("Estado"));
                salas.add(salaSquash);
            }
        
        stm.close();
        rs.close();
        
        return salas;
    }
    
    public void inserirSalaSquash(SalaSquashCompoundSala sala) throws SQLException
    {
        String querySala = "insert into sala (NroSala, Area, Localizacao, TipoSala) \n" +
                            "values ('" + sala.getNroSala() + "', '" + sala.getArea() + "', '" + sala.getLocalizacao() + "', '" + this.tipoSala + "') \n" +
                            "on duplicate key \n" +
                            "update Area = '" + sala.getArea() + "', Localizacao = '" + sala.getLocalizacao() + "', tipoSala = '" + this.tipoSala + "'";
        
        String querySquash = "insert into salaSquash (NroSala, Estado) \n" + 
                             "values ('" + sala.getNroSala() + "', '" + sala.getEstado() + "') \n" +
                             "on duplicate key \n" +
                             "update Estado = '" + sala.getEstado() + "'";
        
        Statement stm = conexao.createStatement();
        stm.executeUpdate(querySala);
        stm.executeUpdate(querySquash);        
        stm.close();
    }
    
    public void deletarSalaSquash(SalaSquashCompoundSala sala) throws SQLException
    {
        String querySala = "delete from sala where NroSala = '" + sala.getNroSala() + "'";
        String querySquash = "delete from salaSquash where NroSala = '" + sala.getNroSala() + "'";
        
        Statement stm = conexao.createStatement();
        stm.executeUpdate(querySquash);
        stm.executeUpdate(querySala);
        stm.close();       
    }
    
    public ArrayList<Integer> blackList() throws SQLException{
        ArrayList<Integer> blackList = new ArrayList<>();
        
        String queryBlackList = "select NroSala\n" +
                                "from sala\n" +
                                "where not TipoSala = '" + this.tipoSala + "';";
        
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(queryBlackList);
        
        while(rs.next())
        {
            blackList.add(rs.getInt("NroSala"));
        }
        
        stm.close();
        rs.close();
        
        return blackList;
    }
    
    public int salasMaxRange() throws SQLException
    {
        int salasMaxRange = 1;
        
        String queryMaxRange =  "select max(NroSala) max\n" +
                                "from sala;";
        
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(queryMaxRange);
        
        while(rs.next()) 
        {
            salasMaxRange = rs.getInt("max");
        }
        
        stm.close();
        rs.close();
        
        return salasMaxRange;
    }
}
