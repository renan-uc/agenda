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
		PreparedStatement ps = null; // monta o comando sql passando parametros

		try {
			System.out.print("Informe o nome do contato que deseja atualizar: ");
			String nomeAtual = sc.nextLine().trim();
			System.out.print("Insira o novo telefone: ");
			long telefone = sc.nextLong();
			
			conn = DB.getConnection();

			ps = conn.prepareStatement(
					"update contato "
					+ "set telefone = ? "
					+ "where "
					+ "(nome = ?)");

			ps.setLong(1, telefone);
			ps.setString(2, nomeAtual);

			ps.executeUpdate();
			System.out.println("Contato atualizado");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(ps);
			DB.closeConnection();
			sc.close();
		}
	}
	}


