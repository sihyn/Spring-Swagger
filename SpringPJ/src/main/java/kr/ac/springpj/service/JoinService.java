package kr.ac.springpj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.springpj.domain.JoinMember;
import kr.ac.springpj.repository.JoinRP;

@Service
public class JoinService {

	@Autowired
	JoinRP joinrp;

	public Optional<JoinMember> findByPersonID(String personID) {
		return joinrp.findByPersonID(personID);
	}

	public List<JoinMember> findAll() {
		return joinrp.findAll();
	}

//	@Transactional(readOnly = true)
//	public void checkPersonID(JoinMember joinmember) {
//		boolean checkIdDuplicate = joinrp.existsByPersonID(joinmember.getPersonID());
//		if (checkIdDuplicate) {
//			throw new IllegalStateException("이미 존재하는 아이디입니다.");
//		}
//	}
	public void checkDuplicateID(JoinMember joinmember) {
		findByPersonID(joinmember.getPersonID()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        });
	}

}
