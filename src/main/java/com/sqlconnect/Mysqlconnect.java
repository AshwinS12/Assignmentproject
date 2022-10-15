package com.sqlconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysqlconnect {
static Mysqlconnect mysql = new Mysqlconnect();
static Connection connect;
private Mysqlconnect() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/comic","root","ashwin2892");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
public static Connection getInstance() {
	return mysql.connect;
}
	public static void main(String[] args) {
		System.out.println(Mysqlconnect.getInstance());
	}
}
