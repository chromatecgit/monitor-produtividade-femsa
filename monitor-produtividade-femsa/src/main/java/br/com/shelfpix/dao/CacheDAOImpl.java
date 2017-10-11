package br.com.shelfpix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		// SQLite connection string
		// TODO:testar!
		// String x = System.getProperty("user.dir").replaceAll("\\\\", "/");
		// String dbFile = x + "/sqlite_db/MonitorFemsaCache.db";
		// String url = "jdbc:sqlite:" + dbFile;
		// Connection conn = null;
		// try {
		// conn = DriverManager.getConnection(url);
		// System.out.println("Connected to database");
		// } catch (SQLException e) {
		// System.out.println(e.getMessage());
		// }
		//
		// String sql = "SELECT * FROM Countries;";
		//
		// try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
		// ResultSet result = pstmt.executeQuery();
		// while(result.next()) {
		// String name = result.getString("name");
		// System.out.println(name);
		// }
		// } catch (SQLException e) {
		// System.out.println(e.getMessage());
		// }
		// return conn.toString();
	}

}
