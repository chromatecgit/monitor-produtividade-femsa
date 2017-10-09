package br.com.shelfpix.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.shelfpix.dao.interfaces.CacheDAO;

@Repository
public class CacheDAOImpl implements CacheDAO {
	
	@Autowired
	@Qualifier("sqlite")
	private JdbcTemplate sqliteTemplate;

	@Override
	public String findCountry() {
		sqliteTemplate.query("SELECT * FROM Countries", rse -> {
			while (rse.next()) {
				System.out.println(rse.getString("name"));
			}
			return "";
		});
		return null;
	}

}
