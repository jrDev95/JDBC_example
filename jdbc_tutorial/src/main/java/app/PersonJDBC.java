package app;

import java.sql.SQLException;
import java.util.*;
import dto.PersonDTO;
import jdbc.*;

public class PersonJDBC {

	public static void main(String[] args) {
		
		DaoPerson personDao = new DaoPersonJdbc();
		PersonDTO personDto = new PersonDTO();
		personDto.setName("Pepe");
		
		
		try {
			personDao.insert(personDto);

			List<PersonDTO> people = personDao.select();
			for(PersonDTO personDTOi : people) {
				System.out.println(personDTOi);
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Data layer exception");
			e.printStackTrace(System.out);
		}
		
	}

}
