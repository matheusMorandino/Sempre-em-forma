/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;
import modelo.Reserva;
import modelo.Reservas_Nomes;
import modelo.Socio;

/**
 *
 * @author jose luiz
 */
public class ReservasSocioDAO {
    
    private final Connection conexao;
    
    public ReservasSocioDAO() throws SQLException
    {
        conexao = FabricaConexao.getConnection();
    }
    
    private ArrayList<Reserva> listarReservas(String query) throws SQLException
    {
        ArrayList<Reserva> reservas = new ArrayList<>();
        
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(query);
        
        while(rs.next()) {
            Reserva reserva = new Reserva(rs.getInt("NroSocio"), rs.getInt("NroSala"), rs.getDate("DataReserva"));
            reservas.add(reserva);
        }
        
        stm.close();
        rs.close();
        
        return reservas;
    }

    public ArrayList<Reserva> listarReservasPeloNomeSocio(Socio socio) throws SQLException
    {
        String query = "select r.NroSocio, r.NroSala, r.DataReserva\n " +
                        "from reserva r\n " +
                        "join socio s\n " +
                        "on s.Nome = '" + socio.getNome() + "' and s.NroSocio = r.NroSocio;";

        return listarReservas(query);
    }
    
    public ArrayList<Reserva> listarReservasPeloNroSocio(Socio socio) throws SQLException
    {
        String query = "select r.NroSocio, r.NroSala, r.DataReserva\n " +
                        "from reserva r\n " +
                        "join socio s\n " +
                        "on s.NroSocio = '" + socio.getNroSocio() + "' and s.NroSocio = r.NroSocio;";
        
        return listarReservas(query);
    }
    
    public ArrayList<Reservas_Nomes> listarReservasSocio() throws SQLException
    {
        ArrayList<Reservas_Nomes> reservasSocio = new ArrayList<>();
        
        String query = "select s.Nome, r.NroSocio, r.NroSala, r.DataReserva\n " +
                        "from reserva r\n " +
                        "join socio s\n " +
                        "on s.NroSocio = r.NroSocio;";
        
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(query);
        
        while(rs.next()) {
            Reservas_Nomes reserva = new Reservas_Nomes(rs.getString("Nome"), rs.getInt("NroSocio"), rs.getInt("NroSala"), rs.getDate("DataReserva"));
            reservasSocio.add(reserva);
        }
        
        stm.close();
        rs.close();
        
        return reservasSocio;
    }
}
