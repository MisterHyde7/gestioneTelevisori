package it.prova.gestioneTelevisori.service.televisore;

import java.util.List;
import java.util.Set;

import it.prova.gestioneTelevisori.dao.televisore.TelevisoreDAO;
import it.prova.gestioneTelevisori.model.Televisore;

public interface TelevisoreService {
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO);

	public Televisore cercaPerId(Long idInput) throws Exception;

	public int inserisciNuovo(Televisore televisoreInput) throws Exception;

	public List<Televisore> listAll() throws Exception;

	public int deleteTelevisore(Televisore televisoreInput) throws Exception;

	public int updateAbitante(Televisore televisoreInput) throws Exception;
	
	public List<Televisore> findByExample(Televisore televisoreInput) throws Exception;

}
