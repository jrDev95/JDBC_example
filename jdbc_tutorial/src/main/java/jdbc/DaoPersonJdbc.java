package jdbc;

import java.sql.*;
import java.util.*;

import dto.PersonDTO;
import jdbc.DaoPerson;

public class DaoPersonJdbc implements DaoPerson{
	
	private java.sql.Connection userConn;
	private final String SQL_INSERT = "INSERT INTO person(name) VALUES(?)";
	private final String SQL_UPDATE = "UPDATE person SET name=? WHERE id_person  = ?";
	private final String SQL_DELETE = "DELETE FROM person WHERE id_person = ?";
	private final String SQL_SELECT = "SELECT * FROM person ORDER BY id_person";
	
	public DaoPersonJdbc(){}

	public DaoPersonJdbc(Connection conn) {
		this.userConn = conn;
	}
	
	public int insert(PersonDTO personDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = (this.userConn != null) ? this.userConn : JConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, personDTO.getName());
			System.out.println("Executing query: " + SQL_INSERT);
			rows = stmt.executeUpdate();
			System.out.println("Affected records: " + rows);
		} finally {
			if(this.userConn == null) {
				JConnection.close(conn);
			}
		}
		return rows;
	}
	
	public int delete(PersonDTO personDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = (this.userConn != null) ? this.userConn : JConnection.getConnection();
			System.out.println("Executing query: " + SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, personDTO.getIdPerson());
			rows = stmt.executeUpdate();
			System.out.println("Deleted records: " + rows);
		} finally {
			if(this.userConn == null) {
				JConnection.close(conn);
			}
		}
		return rows;
	}
	
	public List<PersonDTO> select() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PersonDTO person = null;
		List<PersonDTO> people = new ArrayList<PersonDTO>();
		
		try {
			conn = (this.userConn != null) ? this.userConn : JConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int id_person = rs.getInt(1);
				String name = rs.getString(2);
				person = new PersonDTO();
				person.setIdPerson(id_person);
				person.setName(name);
				people.add(person);
			}
		} finally {
			if(this.userConn == null) {
				JConnection.close(conn);
			}
		}
		return people;
	}
	
	public int update(PersonDTO personDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
			
		try {
			conn = (this.userConn != null) ? this.userConn : JConnection.getConnection();
			System.out.println("Executing query: " + SQL_UPDATE);
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, personDTO.getName());
			stmt.setInt(2, personDTO.getIdPerson());
			rows = stmt.executeUpdate();
			System.out.println("Updated records: " + rows );
		} finally {
			if(this.userConn == null) {
				JConnection.close(conn);
			}
		}
		return rows;
	}
}
