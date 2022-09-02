package kr.ac.springpj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import kr.ac.springpj.domain.JoinMember;
import kr.ac.springpj.repository.JoinRP;
import kr.ac.springpj.service.JoinService;

@SpringBootApplication
@RestController
public class JoinController {

	@Autowired
	JoinRP joinrp;

	@Autowired
	JoinService joinservice;

	@PostMapping("/join")
	@ApiOperation(value = "회원 가입")
	@ResponseBody
	@Valid
	public JoinMember save(JoinMember joinvo) {
		joinservice.checkDuplicateID(joinvo);
		return joinrp.save(joinvo);
	}

	@GetMapping("/readAll")
	@ApiOperation(value = "회원 전체 조회")
	@ResponseBody
	public List<JoinMember> readAll() {
		List<JoinMember> joinmember = joinservice.findAll();
		return joinmember;
	}

	@GetMapping("/readOne")
	@ApiOperation(value = "회원 개별 조회")
	@ResponseBody
	public JoinMember readOne(@RequestParam("personID") String personID) {
		JoinMember joinmember = joinservice.findByPersonID(personID).get();
		return joinmember;
	}

	@PutMapping("/updateAll")
	@ApiOperation(value = "전체 수정")
	@ResponseBody
	public JoinMember updateAll(@RequestParam("personID") String personID, JoinMember joinvo) {
		JoinMember joinmember = joinservice.findByPersonID(personID).get();
		joinmember.setPersonID(joinvo.getPersonID());
		joinmember.setPersonPW(joinvo.getPersonPW());
		joinmember.setName(joinvo.getName());
		joinmember.setBirth(joinvo.getBirth());
		joinmember.setAddress(joinvo.getAddress());
		joinmember.setPhone(joinvo.getPhone());
		joinmember.setGender(joinvo.getGender());
		joinmember.setAge(joinvo.getAge());

		return joinrp.save(joinmember);
	}

	@PatchMapping("/updatePW")
	@ApiOperation(value = "비밀번호 수정")
	@ResponseBody
	public JoinMember updatePW(@RequestParam("personID") String personID, @RequestParam("personPW") String personPW) {
		JoinMember joinmember = joinservice.findByPersonID(personID).get();
		joinmember.setPersonPW(personPW);

		return joinrp.save(joinmember);
	}

	@DeleteMapping("/delete")
	@ApiOperation(value = "회원 삭제")
	@ResponseBody
	public JoinMember delete(@RequestParam("PersonID") String personID) {
		JoinMember joinmember = joinrp.findByPersonID(personID).get();
		joinrp.delete(joinmember);

		return joinmember;
	}

}
