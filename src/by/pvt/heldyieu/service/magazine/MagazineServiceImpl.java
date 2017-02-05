package by.pvt.heldyieu.service.magazine;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.dao.implementation.MagazineDAOImpl;
import by.pvt.heldyieu.entity.Magazine;

public class MagazineServiceImpl implements IMagazineService {
	private static final Logger LOGGER = Logger.getLogger(MagazineServiceImpl.class);
	private MagazineDAOImpl magazineDao;
	private static MagazineServiceImpl INSTANCE = null;
	
	private MagazineServiceImpl() {
		LOGGER.info("Create new MagazineDAOImpl entity");
		magazineDao = MagazineDAOImpl.getInstance();
	}
	
	public static MagazineServiceImpl getInstance(){
		LOGGER.info("Getting MagazineService entity");
		if (INSTANCE == null) {
			INSTANCE = new MagazineServiceImpl();
		} 
		return INSTANCE;
	}
	
	@Override
	public Magazine addMagazine(Magazine magazine) throws SQLException {
		LOGGER.info("Try to add new magazine in database");
		return magazineDao.create(magazine);
    }
	
	@Override
	public Magazine getMagazine(Integer id) throws SQLException {
		LOGGER.info("Try to get magazine by Id");
		return magazineDao.readById(id);
    }
	
	@Override
	public void updateMagazine(Magazine magazine) throws SQLException {
		LOGGER.info("Try to update magazine");
		magazineDao.update(magazine);
    }
	
	@Override
	public void deleteMagazine(Magazine magazine) throws SQLException {
		LOGGER.info("Try to delete magazine");
		magazineDao.delete(magazine);
    }
	
	@Override
	public List<Magazine> getAllMagazines() throws SQLException {
		LOGGER.info("Try to get all magazines");
		return magazineDao.getAll();
    }
	
	@Override
	public Magazine findMagazineByName(String name) throws SQLException {
		LOGGER.info("Try to find magazine by name");
		return magazineDao.findMagazineByName(name);
    }
}
