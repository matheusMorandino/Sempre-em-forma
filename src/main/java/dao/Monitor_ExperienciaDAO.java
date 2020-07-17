/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Monitor_Experiencia;
import java.sql.*;
import java.util.*;

/**
 *
 * @author jose luiz
 */
public class Monitor_ExperienciaDAO {
    
    private final Connection conexao;
    
    public Monitor_ExperienciaDAO() throws SQLException
    {
        conexao = FabricaConexao.getConnection();
    }
    
    public ArrayList<Monitor_Experiencia> listarMonitores() throws SQLException
    {
        ArrayList<Monitor_Experiencia> monitores = new ArrayList<>();
        
        String query = "select m.RG, m.Nome, m.Telefone, m.Titulacao, e.CodExpProf, e.Exp_Prof \n" +
                        "from monitor m \n" +
                        "join experienciprofisional e \n" +
                        "on m.RG = e.RG";
        
        PreparedStatement stm = conexao.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        
        while(rs.next())
        {
            Monitor_Experiencia monitor = new Monitor_Experiencia(rs.getString("RG"), rs.getString("Nome"), rs.getString("Telefone"), rs.getString("Titulacao"), rs.getString("Exp_Prof"), rs.getInt("CodExpProf"));
            monitores.add(monitor);
        }
        
        stm.close();
        rs.close();
        
        return monitores;
    }
    
    public void inserirMonitor(Monitor_Experiencia monitor) throws SQLException
    {
        String queryMonitor = "insert into monitor (RG, Nome, Telefone, Titulacao) \n" +
                               "values (" + monitor.getRG() + ", '" + monitor.getNome() + "', '" + monitor.getTelefone() + "', '" + monitor.getTitulacao() + "') \n" +
                               "on duplicate key \n" +
                               "update Nome='" + monitor.getNome() + "', Telefone='" + monitor.getTelefone() + "', Titulacao='" + monitor.getTitulacao() + "'";
        
        String queryExperiencia = "insert into experienciprofisional (CodExpProf, Exp_Prof, RG) \n" +
                                   "values (" + monitor.getCodExpProf() + ", '" + monitor.getExp_Prof() + "', '" + monitor.getRG() + "') \n" +
                                   "on duplicate key \n" +
                                   "update Exp_Prof='" + monitor.getExp_Prof() + "', RG='" + monitor.getRG() + "'";
        
        Statement stm = conexao.createStatement();
        stm.executeUpdate(queryMonitor);
        stm.executeUpdate(queryExperiencia);
        stm.close();
    }
    
    public void deletarMonitor(Monitor_Experiencia monitor) throws SQLException
    {
        String query =  "delete A\n" +
                        "from experienciprofisional A\n" +
                        "join monitor B on (A.RG=B.RG)\n" +
                        "where B.RG='" + monitor.getRG() + "';";
        
        Statement stm = conexao.createStatement();
        stm.executeUpdate(query);
        stm.close();
    }
    
}
