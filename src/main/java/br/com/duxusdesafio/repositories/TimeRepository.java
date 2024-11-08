package br.com.duxusdesafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.duxusdesafio.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long>{

	@Query("SELECT t FROM Time t WHERE YEAR(t.data) = :ano")
	List<Time> findByYear(@Param("ano") int ano);
	
}
