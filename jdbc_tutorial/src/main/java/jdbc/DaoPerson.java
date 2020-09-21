package jdbc;

import java.sql.SQLException;
import java.util.List;
import dto.PersonDTO;

public interface DaoPerson {
	public int insert(PersonDTO person) throws SQLException;
	public int update(PersonDTO person) throws SQLException;
	public int delete(PersonDTO person) throws SQLException;
	public List<PersonDTO> select() throws SQLException;
}
