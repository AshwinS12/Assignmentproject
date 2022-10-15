package com.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Encapsulation;
import com.sqlconnect.Mysqlconnect;

public class WebImplementation {
Connection connect;
PreparedStatement pstate;
ResultSet resultset;
Statement state;

public WebImplementation () {
	connect=Mysqlconnect.getInstance();
}
public int Insert(Encapsulation ec) {
	int result = 0;
	String query = "insert into story values(?,?,?,?)";
	try {
		pstate = connect.prepareStatement(query);
		pstate.setString(1, ec.getId());
		pstate.setString(2,ec.getDescripton());
		pstate.setString(3, ec.getGenre());
		pstate.setInt(4, ec.getSold());
		result = pstate.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return result;
}

public int delete(Encapsulation e) {
	int result=0;
	String query = "delete from story where id = "+e.getId()+";";
	try {
		state=connect.createStatement();
		result=state.executeUpdate(query);
	}catch(SQLException i) {
		i.printStackTrace();
	}
	return result;
}
public int update (Encapsulation ec) {
	int result = 0;
	String query ="update story set sold = ? where id = ?";
	try {
		pstate = connect.prepareStatement(query);
		pstate.setInt(1, ec.getSold());
		pstate.setString(2, ec.getId());
		result = pstate.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}return result;
}
public Encapsulation Search(String ec) {
	Encapsulation result = null;
	String query = "select * from story where id = ?";
	try {
		pstate = connect.prepareStatement(query);
		pstate.setString(1, ec);
		resultset=pstate.executeQuery();
		while(resultset.next()) {
			result = new Encapsulation();
			result.setId(resultset.getString(1));
			result.setDescripton(resultset.getString(2));
			result.setGenre(resultset.getString(3));
			result.setSold(resultset.getInt(4));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}return result;
}
public List<Encapsulation>Fetch(){
	List<Encapsulation>list = new ArrayList<Encapsulation>();
	Encapsulation result= null;
	String query = "Select * from story";
	try {
		pstate=connect.prepareStatement(query);
		resultset=pstate.executeQuery();
		while(resultset.next()) {
			result = new Encapsulation();
			result.setId(resultset.getString(1));
			result.setDescripton(resultset.getString(2));
			result.setGenre(resultset.getString(3));
			result.setSold(resultset.getInt(4));
			list.add(result);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}return list;
}
}
