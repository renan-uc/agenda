package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

			Connection conn = null;
			Statement st = null; // monta o comando sql sem passar parametros
			ResultSet rs = null; // objeto resultado do comando em forma de tabela
		
		
			StringBuilder sb = new StringBuilder();
			try {
				conn = DB.getConnection();
				st = conn.createStatement();
				rs = st.executeQuery("select * from contato");

				while (rs.next()) {
					sb.append(rs.getString("nome") + " " + rs.getLong("telefone") + "\n");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB.closeResultSet(rs);
				DB.closeStatement(st);
				DB.closeConnection();
			}
			System.out.println(sb.toString());
	}
	}


