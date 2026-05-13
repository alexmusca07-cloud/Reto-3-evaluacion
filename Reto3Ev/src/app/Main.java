package app;

import java.sql.Connection;

import util.ConexionBD;

public class Main {

	public static void main(String[] args) {

				try (Connection con = ConexionBD.getConnection()) {
					if (con != null) {
						System.out.println("CONEXIÓN EXITOSA");
					} else {
						System.out.println("Fallo Conexión");
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());

				}
			}
		}

