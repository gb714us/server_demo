package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlCommand {
	// Inserts a game request into the matchmaking table for the given game using the given userid
	public static void createGameRequest(String game, String userid) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs;

		String table = game.toLowerCase() + "_matchmaking";
		
		String url = "jdbc:mysql://inf122.davidlepe.com:3306/finalproj";
		String user = "inf122";
		String password = "password";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String uid = "123";
			pst = con.prepareStatement("INSERT INTO " + table + "(userid) VALUES ('" + userid + "');");
			rs = pst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find driver :(");
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	// Returns a list of game requests that are not requested by the given userid
	public static List<String> retrieveListOfGameRequests(String game, String userid) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String table = game.toLowerCase() + "_matchmaking";
		
		String url = "jdbc:mysql://inf122.davidlepe.com:3306/finalproj";
		String user = "inf122";
		String password = "password";
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String uid = "123";
			pst = con.prepareStatement("SELECT * FROM " + table + " WHERE userid !='" + userid + "'");
			rs = pst.executeQuery();
			
			while (rs.next()) {
				result.add(rs.getString(2));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find driver :(");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					pst.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	// Returns a list of game requests that are not requested by the given userid
		public static void removeGameRequest(String game, String userid) {
			Connection con = null;
			PreparedStatement pst = null;
			int rs;

			String table = game.toLowerCase() + "_matchmaking";
			
			String url = "jdbc:mysql://inf122.davidlepe.com:3306/finalproj";
			String user = "inf122";
			String password = "password";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				pst = con.prepareStatement("DELETE FROM " + table + " WHERE userid = '" + userid + "'");
				rs = pst.executeUpdate();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Could not find driver :(");
				e.printStackTrace();
			} finally {
				try {
					if (pst != null) {
						pst.close();
					}
					if (con != null) {
						con.close();
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		public static void removeFromUserTable(String userid) {
			Connection con = null;
			PreparedStatement pst = null;
			int rs;

			String table = "users";
			
			String url = "jdbc:mysql://inf122.davidlepe.com:3306/finalproj";
			String user = "inf122";
			String password = "password";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				pst = con.prepareStatement("DELETE FROM " + table + " WHERE user_name = '" + userid + "';");
				rs = pst.executeUpdate();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Could not find driver :(");
				e.printStackTrace();
			} finally {
				try {
					if (pst != null) {
						pst.close();
					}
					if (con != null) {
						con.close();
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
}
