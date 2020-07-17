/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;
import modelo.SalaSquash;

/**
 *
 * @author jose luiz
 */
public class SalaSquashDAO {
    
    private final Connection conexao;
    
    public SalaSquashDAO() throws SQLException
    {
        conexao = FabricaConexao.getConnection();
    }
    
    public ArrayList<SalaSquash> listarSalas() throws SQLException
    {
        ArrayList<SalaSquash> salas = new ArrayList<>();
        
        String query = "select NroSala\n " +
                        "from salasquash;";
        
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while(rs.next()) {
            SalaSquash sala = new SalaSquash(rs.getInt("NroSala"));
            salas.add(sala);
        }
        
        stm.close();
        rs.close();
        
        return salas;
    }
}
