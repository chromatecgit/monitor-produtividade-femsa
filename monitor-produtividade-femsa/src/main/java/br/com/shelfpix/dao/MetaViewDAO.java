package br.com.shelfpix.dao;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Component;

import br.com.shelfpix.model.dto.MetaViewDTO;

@Component
public class MetaViewDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<MetaViewDTO> findAll() {
		CacheDAOImpl cache = new CacheDAOImpl();
				cache.findCountry();
		StoredProcedureQuery query = manager.createStoredProcedureQuery("spxPkgMeta")
				.registerStoredProcedureParameter("dataInicio", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("dataFim", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("idCompanhia", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("idItinerario", Integer.class, ParameterMode.IN);
				
		query.setParameter("dataInicio", "2017-07-01");
		query.setParameter("dataFim", "2017-07-31");
		query.setParameter("idCompanhia", 6);
		query.setParameter("idItinerario", 100003);
		
		long inicio = System.currentTimeMillis();
		System.out.println("INICIO - PROCEDURE");
		
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = query.getResultList();
		
		List<MetaViewDTO> listaMetaViewDTO = new ArrayList<>();
		for (Object[] obj : resultList) {
			MetaViewDTO metaViewDTO = new MetaViewDTO();
			metaViewDTO.setIdPesquisador((int) obj[0]);
			metaViewDTO.setNome((String) obj[1]);
			metaViewDTO.setSobrenome((String) obj[2]);
			metaViewDTO.setDataVisita(((Timestamp) obj[3]).toLocalDateTime().toLocalDate());
			metaViewDTO.setTotalLojasVisitar((int) obj[4]);
			metaViewDTO.setTotalDiasUteis((int) obj[5]);
			metaViewDTO.setHorasTrabalhadasDia((int) obj[6]);
			metaViewDTO.setNumeroLojasVisitadas((int) obj[7]);
			metaViewDTO.setNumeroLojasRecusadas((int) obj[8]);
			metaViewDTO.setFlagDiaUtil((boolean) obj[9]);
			metaViewDTO.setHorasTrabalhadas(LocalTime.parse(obj[10].toString().replace("-", "")));
			metaViewDTO.setFotosPublicadas((int) obj[11]);
			metaViewDTO.setFotosOcorrencia((int) obj[12]);
			metaViewDTO.setFotosEvidencia((int) obj[13]);
			metaViewDTO.setPrecosPublicados((int) obj[14]);
			
			listaMetaViewDTO.add(metaViewDTO);
		}
		
		manager.close();
		long fim = System.currentTimeMillis();
		System.out.println("FIM - PROCEDURE em " + ((fim - inicio)/1000) / 60 + " minutos");
		return listaMetaViewDTO;
	}
}
