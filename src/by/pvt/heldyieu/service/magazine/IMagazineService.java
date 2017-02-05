package by.pvt.heldyieu.service.magazine;

import java.sql.SQLException;
import java.util.List;

import by.pvt.heldyieu.entity.Magazine;

public interface IMagazineService {
	
	 Magazine addMagazine(Magazine magazine) throws SQLException;
	
	 Magazine getMagazine(Integer id) throws SQLException;
	
	 void updateMagazine(Magazine magazine) throws SQLException;
	
	 void deleteMagazine(Magazine magazine) throws SQLException;
	
	 List<Magazine> getAllMagazines() throws SQLException;
	
	 Magazine findMagazineByName(String name) throws SQLException;
}