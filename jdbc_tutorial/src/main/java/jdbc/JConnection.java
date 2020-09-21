package jdbc;

import java.sql.*;


/**
 * DB Connection class
 * @author jrd
 *
 */
public class JConnection {
	
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://172.17.0.2/person?useSSL=false";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "root";
	private static Driver driver;

//	Legacy
//	@SuppressWarnings("deprecation")
//	public static synchronized Connection getConnection() throws SQLException {
//		if (driver == null) {
//			try {
//				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
//				driver = (Driver) jdbcDriverClass.newInstance();
//				DriverManager.registerDriver(driver);
//			} catch (Exception e) {
//				System.out.println("JDBC load failed");
//				e.printStackTrace(System.out);
//			}
//			return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
//		}
//	}
	
	public static synchronized Connection getConnection() throws SQLException {
		if (driver == null) {
			Connection connection = null;
			
			try {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
				
			} catch (Exception e) {
				System.out.println("JDBC load failed");
				e.printStackTrace(System.out);
			}
			return connection;
		}
		return null;
	}
	
	//Close resultSet object
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}
	
	// Close PrepareStatement object
	public static void close(PreparedStatement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}
	
	// Close Connection object
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}
	
}
