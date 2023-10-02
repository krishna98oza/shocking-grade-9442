package com.masai.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.Model.CurrentUserSession;

@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession , Integer>{

	Optional<CurrentUserSession> findByUuid(String uuid);
	
	@Query("SELECT c FROM CurrentUserSession c WHERE c.uuid = :uuid AND c.currRole = 'admin'")
	Optional<CurrentUserSession> findByUuidAndRole(@Param("uuid") String uuid);
}
