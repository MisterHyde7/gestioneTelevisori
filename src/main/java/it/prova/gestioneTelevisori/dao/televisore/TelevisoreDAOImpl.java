package it.prova.gestioneTelevisori.dao.televisore;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.prova.gestioneTelevisori.dao.DB_Mock;
import it.prova.gestioneTelevisori.model.Televisore;

public class TelevisoreDAOImpl implements TelevisoreDAO {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Televisore> list() throws Exception {
		return DB_Mock.LISTA_TELEVISORI;
	}

	@Override
	public Televisore get(Long id) throws Exception {

		Televisore result = new Televisore();

		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if (televisoreItem.getId() == id)
				result = televisoreItem;
		}

		return result;

	}

	@Override
	public int update(Televisore input) throws Exception {
//		this.get(input.getIdAbitante()).setNome(input.getNome());
//		this.get(input.getIdAbitante()).setCognome(input.getCognome());
//		return 1;

		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if (televisoreItem.getId() == input.getId()) {
				televisoreItem.setMarca(input.getMarca());
				televisoreItem.setModello(input.getModello());
				televisoreItem.setPrezzo(input.getPrezzo());
				televisoreItem.setNumeroPollici(input.getNumeroPollici());
				televisoreItem.setCodice(input.getCodice());
			}
		}
		return 1;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		input.setId(DB_Mock.getNexIdAvailable());
		return DB_Mock.LISTA_TELEVISORI.add(input) ? 1 : 0;
	}

	@Override
	public int delete(Televisore input) throws Exception {
		return DB_Mock.LISTA_TELEVISORI.remove(input) ? 1 : 0;
	}

	@Override
	public List<Televisore> findByExample(Televisore televisoreInput) throws Exception {

		List<Televisore> listaSuDB = this.list();
		List<Televisore> listaDiTelevisoriPerRicerca = new ArrayList<>();

		for (Televisore televisoreItem : listaSuDB) {

			if (televisoreItem.getMarca().startsWith(televisoreInput.getMarca())
					&& televisoreItem.getModello().startsWith(televisoreInput.getModello())
					&& televisoreItem.getPrezzo() >= (televisoreInput.getPrezzo())
					&& televisoreItem.getNumeroPollici() >= (televisoreInput.getNumeroPollici())
					&& televisoreItem.getCodice().startsWith(televisoreInput.getCodice())) {
				listaDiTelevisoriPerRicerca.add(televisoreItem);
			}

		}
		return listaDiTelevisoriPerRicerca;
	}

}
