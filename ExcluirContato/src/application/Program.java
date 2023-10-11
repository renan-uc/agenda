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
			System.out.print("Informe o nome do contato a ser excluido ");
			String nome = sc.nextLine();
			
			conn = DB.getConnection();

			ps = conn.prepareStatement("delete from contato " + "where " + "nome =  (?)");

			ps.setString(1, nome);

			ps.executeUpdate();
			System.out.println("Contato excluido");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(ps);
			DB.closeConnection();
			sc.close();
		}
	}
	}


