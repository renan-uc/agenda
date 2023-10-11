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
			System.out.print("Informe o nome do contato que deseja atualizar: ");
			String nomeAtual = sc.nextLine().trim();
			System.out.print("Insira o novo nome: ");
			String nome = sc.nextLine().trim();
			
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"update contato "
					+ "set nome = ? "
					+ "where "
					+ "(nome = ?)");

			st.setString(1, nome);
			st.setString(2, nomeAtual);

			st.executeUpdate();
			System.out.println("Contato atualizado");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
			sc.close();
		}
	}
	}


