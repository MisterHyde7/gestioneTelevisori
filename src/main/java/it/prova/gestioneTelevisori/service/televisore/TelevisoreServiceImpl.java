package it.prova.gestioneTelevisori.service.televisore;

import java.util.List;

import it.prova.gestioneTelevisori.dao.televisore.TelevisoreDAO;
import it.prova.gestioneTelevisori.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {

	private TelevisoreDAO televisoreDAO;

	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;
	}

	@Override
	public Televisore cercaPerId(Long idInput) throws Exception {
		return televisoreDAO.get(idInput);
	}

	@Override
	public int inserisciNuovo(Televisore televisoreInput) throws Exception {
		return televisoreDAO.insert(televisoreInput);
	}

	@Override
	public List<Televisore> listAll() throws Exception {
		return televisoreDAO.list();
	}

	@Override
	public int deleteAbitante(Televisore televisoreInput) throws Exception {
		return televisoreDAO.delete(televisoreInput);
	}

	@Override
	public int updateAbitante(Televisore televisoreInput) throws Exception {
		return televisoreDAO.update(televisoreInput);
	}

	@Override
	public List<Televisore> findByExample(Televisore televisoreInput) throws Exception {
		return televisoreDAO.findByExample(televisoreInput);
	}

}
