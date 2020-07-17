/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.text.*;
import java.util.*;
import modelo.Reserva;
import modelo.Sala;
import modelo.Socio;

/**
 *
 * @author jose luiz
 */
public class ReservasDAO {

    private final Connection conexao;
    
    public ReservasDAO() throws SQLException
    {
        conexao = FabricaConexao.getConnection();
    }

    public ArrayList<Reserva> listarReservasPeloNroSala(Sala sala) throws SQLException
    {
        ArrayList<Reserva> datasSala = new ArrayList<>();
        
        String query = "select DataReserva\n" +
                        "from reserva\n" +
                        "where NroSala = '" + sala.getNroSala() + "';";
        
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(query);
        
        while(rs.next()) {
            Reserva reserva = new Reserva(rs.getDate("DataReserva"));
            datasSala.add(reserva);
        }
        
        return datasSala;
    }
    
    public void inserirReservaPeloNomeSocio(Reserva reserva, Socio socio) throws SQLException
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String query = "insert into reserva (NroSocio, NroSala, DataReserva)\n " +
                        "values ( (select s.NroSocio from Socio s where s.Nome = '" + socio.getNome() + "'),\n " +
                        "'" + reserva.getNroSala() + "', '" + df.format(reserva.getDataReserva()) + "')\n " +
                        "on duplicate key \n " +
                        "update DataReserva = '" + df.format(reserva.getDataReserva()) + "';";
        
        Statement stm = conexao.createStatement();
        stm.executeUpdate(query);
        stm.close();
    }
    
    public void inserirReservaPeloNroSocio(Reserva reserva) throws SQLException
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String query = "insert into reserva (NroSocio, NroSala, DataReserva)\n " +
                        "values ('" + reserva.getNroSocio() + "', '" + reserva.getNroSala() + "', '" + df.format(reserva.getDataReserva()) + "')\n " +
                        "on duplicate key \n " +
                        "update DataReserva = '" + df.format(reserva.getDataReserva()) + "';";
                
        Statement stm = conexao.createStatement();
        stm.executeUpdate(query);
        stm.close();
    }
    
    public void deletarReservaPeloNroSocio(Reserva reserva) throws SQLException
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String query = "delete from reserva\n " +
                        "where NroSala = '" + reserva.getNroSala() + "' and NroSocio = '" + reserva.getNroSocio() + "' and DataReserva = '" + df.format(reserva.getDataReserva()) + "';";
        
        Statement stm = conexao.createStatement();
        stm.executeUpdate(query);
        stm.close();
    }
    
    public void deletarReservaPeloNomeSocio(Reserva reserva, Socio socio) throws SQLException
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String query = "delete from reserva\n " +
                    "where NroSala = '" + reserva.getNroSala() + "' and DataReserva = '" + df.format(reserva.getDataReserva()) + "'\n " +
                    "and NroSocio = (select s.NroSocio from socio s where s.Nome = '" + socio.getNome() + "');";
        
        Statement stm = conexao.createStatement();
        stm.executeUpdate(query);
        stm.close();
    }
}
