/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regis.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daypn
 */
public class ConnectionFactory {
 
    public static Connection getConnection() throws SQLException {
	return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Regis", "postgres", "day293847");
    }
}

