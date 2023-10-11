package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		ResultSet rs = null; // objeto resultado do comando em forma de tabela
		PreparedStatement ps = null; // monta o comando sql passando parametros

		StringBuilder sb = new StringBuilder();
		try {
			conn = DB.getConnection();
			
			rs = ps.executeQuery("select * from contato where nome like %(?)%");
			
			while (rs.next()) {
				sb.append(rs.getString("nome") + " " + rs.getLong("telefone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
			DB.closeConnection();
		}
		System.out.println(sb.toString());			
		}
	}
	


