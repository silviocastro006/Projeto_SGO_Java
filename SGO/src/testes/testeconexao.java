/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.Conexao;

/**
 *
 * @author acer
 */
public class testeconexao {
    public static void main(String[] args) {
       Conexao conn = new Conexao();
       conn.conectar();
       conn.desconectar();
    }
    
}