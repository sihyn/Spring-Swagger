package kr.ac.springpj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.springpj.domain.JoinMember;

@Repository
public interface JoinRP extends JpaRepository<JoinMember, Integer>, JpaSpecificationExecutor<JoinMember> {
	
	Optional<JoinMember> findByPersonID(String personID);

	boolean existsByPersonID(String personID);
}
