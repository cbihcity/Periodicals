package by.pvt.heldyieu.service;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.dao.implementation.MagazineDAOImpl;
import by.pvt.heldyieu.entity.Magazine;

public class MagazineService {
	private static final Logger LOGGER = Logger.getLogger(MagazineService.class);
	private MagazineDAOImpl magazineDao;
	private static MagazineService INSTANCE = null;
	
	private MagazineService() {
		LOGGER.info("Create new MagazineDAOImpl entity");
		magazineDao = new MagazineDAOImpl();
	}
	
	public static MagazineService getInstance(){
		LOGGER.info("Getting MagazineService entity");
		if (INSTANCE == null) {
			INSTANCE = new MagazineService();
		} 
		return INSTANCE;
	}
	
	public Magazine addMagazine(Magazine magazine) throws SQLException {
		LOGGER.info("Try to add new magazine in database");
		return magazineDao.create(magazine);
    }
	
	public Magazine getMagazine(Integer id) throws SQLException {
		LOGGER.info("Try to get magazine by Id");
		return magazineDao.readById(id);
    }
	
	public void updateMagazine(Magazine magazine) throws SQLException {
		LOGGER.info("Try to update magazine");
		magazineDao.update(magazine);
    }
	
	public void deleteMagazine(Magazine magazine) throws SQLException {
		LOGGER.info("Try to delete magazine");
		magazineDao.delete(magazine);
    }
	
	public List<Magazine> getAllMagazines() throws SQLException {
		LOGGER.info("Try to get all magazines");
		return magazineDao.getAll();
    }
	
	public Magazine findMagazineByName(String name) throws SQLException {
		LOGGER.info("Try to find magazine by name");
		return magazineDao.findMagazineByName(name);
    }
}
