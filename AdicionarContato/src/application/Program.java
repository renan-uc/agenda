package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement st = null; // monta o comando sql passando parametros

		try {
			System.out.print("Informe o nome do novo contato: ");
			String nome = sc.nextLine().trim();
			System.out.print("Informe o telefone do novo contato: ");
			long telefone = sc.nextLong();
			
			conn = DB.getConnection();

			st = conn.prepareStatement("INSERT INTO contato" + "(nome,telefone) " + "VALUES" + "(?, ?)");

			st.setString(1, nome);
			st.setLong(2, telefone);
			st.executeUpdate();
			System.out.println("Contato adicionado");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
			sc.close();
		}
	}
	}


