package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	public static void main(String[] args) {
		createTable();
	}
	
	public static Boolean getLogin(String ID, String PW) {
		Connection con = getConnection();
		try {
			String sql = "SELECT * FROM User WHERE ID = ? AND PW = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, ID);
			statement.setNString(2, PW);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				result.close();
				return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return false;
	}
	
	public static Boolean getAdminLogin(String ID, String PW) {
		Connection con = getConnection();
		try {
			String sql = "SELECT * FROM Admin WHERE ID = ? AND PW = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, ID);
			statement.setNString(2, PW);
			ResultSet result = statement.executeQuery();
			if(result.next())
				return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return false;
	}
	
	public static Boolean getAdminJoin() {
		Connection con = getConnection();
		try {
			String sql = "SELECT EXISTS(SELECT * FROM Admin) AS cnt";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			if(result.next())
				return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return false;
	}
	
	public static String getName(int num) {
		Connection con = getConnection();
		try {
			String sql = "SELECT Name FROM User WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, num);
			ResultSet result = statement.executeQuery();
			if(result.next())
				return result.getNString("Name");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return null;
	}
	
	public static String getID(int num) {
		Connection con = getConnection();
		try {
			String sql = "SELECT ID FROM User WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, num);
			ResultSet result = statement.executeQuery();
			if(result.next())
				return result.getNString("ID");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return null;
	}
	
	public static String getRemain(int num) {
		Connection con = getConnection();
		try {
			String sql = "SELECT Remain FROM User WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, num);
			ResultSet result = statement.executeQuery();
			if(result.next())
				return String.valueOf(result.getInt("Remain"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return null;
	}
	
	public static void setRemain(int num, int coin) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET Remain = Remain + ? WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, coin);
			statement.setInt(2, num);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void ChangeRemain(String ID, int coin) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET Remain = ? WHERE ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, coin);
			statement.setNString(2, ID);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void MinusRemain(int num, int coin) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET Remain = Remain - ? WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, coin);
			statement.setInt(2, num);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String getUsingCoin(int num) {
		Connection con = getConnection();
		try {
			String sql = "SELECT UsingCoin FROM User WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, num);
			ResultSet result = statement.executeQuery();
			if(result.next())
				return String.valueOf(result.getInt("UsingCoin"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return null;
	}
	
	public static void setUsingCoin(int num, int coin) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET UsingCoin = UsingCoin + ? WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, coin);
			statement.setInt(2, num);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void resetUsingCoin(int num) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET UsingCoin = 0 WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, num);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void MinusUsingCoin(int num) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET UsingCoin = UsingCoin - 1 WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, num);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void MergeUsingCoin(String ID) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET Remain = Remain + UsingCoin, UsingCoin = 0 WHERE ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, ID);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void setRoom(String ID, int num) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET Room = ? WHERE ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, num);
			statement.setNString(2, ID);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Boolean checkRoom(int num) {
		Connection con = getConnection();
		try {
			String sql = "SELECT COUNT(*) cnt FROM User WHERE Room=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, num);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				int cnt = result.getInt("cnt");
				if (cnt>0)
					return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return false;
	}
	
	public static Boolean getState(String State, int num) {
		Connection con = getConnection();
		try {
			String sql = "SELECT * FROM User WHERE Room = ? AND State = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, num);
			statement.setNString(2, State);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				result.close();
				return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return false;
	}
	
	public static void setOnState(String ID) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET State = 'ONLINE' WHERE ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, ID);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void setOffState(String ID) {
		Connection con = getConnection();
		try {
			String sql = "UPDATE User SET State = 'OFFLINE' WHERE ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, ID);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Boolean checkID(String ID) {
		Connection con = getConnection();
		try {
			String sql = "SELECT COUNT(*) cnt FROM User WHERE ID=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, ID);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				int cnt = result.getInt("cnt");
				if (cnt>0)
					return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return false;
	}
	
	public static void deleteUser(String ID) {
		Connection con = getConnection();
		try {
			String sql = "DELETE FROM User WHERE ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, ID);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String[][] getUsers() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT Name, ID, Remain, UsingCoin, Room, State FROM User");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("Name"),
						results.getString("ID"),
						results.getString("Remain"),
						results.getString("UsingCoin"),
						results.getString("Room"),
						results.getString("State")
						});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][6];
			return list.toArray(arr);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void createUser(String Name, String ID, String PW) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO User"
					+ "(Name, ID, PW) "
					+ "VALUES "
					+ "('" + Name + "','" + ID + "','" + PW + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createAdmin(String Name, String ID, String PW) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO Admin"
					+ "(Name, ID, PW) "
					+ "VALUES "
					+ "('" + Name + "','" + ID + "','" + PW + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS "
							+ "User("
							+ "Name varChar(20),"
							+ "ID varChar(20),"
							+ "PW varChar(20),"
							+ "Remain int(255) DEFAULT 0,"
							+ "UsingCoin int(255) DEFAULT 0,"
							+ "Room int(255) DEFAULT 0,"
							+ "State varChar(20) DEFAULT 'OFFLINE',"
							+ "PRIMARY KEY(ID))");
			createTable.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}
	
	public static void createAdminTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS "
							+ "Admin("
							+ "Name varChar(20),"
							+ "ID varChar(20),"
							+ "PW varChar(20),"
							+ "PRIMARY KEY(ID))");
			createTable.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}

	public static Connection getConnection() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/coin";
			String dbID = "root";
			String dbPW = "qwe123";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
			System.out.println("The Connection Successful");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}