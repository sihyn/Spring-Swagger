package kr.ac.springpj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="joinvo")
public class JoinMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@ApiModelProperty(example = "아이디")
	@NotBlank
	private String personID;
	
	@ApiModelProperty(example = "비밀번호")
	@NotBlank
	private String personPW;
	
	@ApiModelProperty(example = "이름")
	@NotBlank
	private String name;
	
	@ApiModelProperty(example = "생년월일(6자리)")
	private int birth;
	
	@ApiModelProperty(example = "주소")
	private String address;
	
	@ApiModelProperty(example = "전화번호")
	private String phone;
	
	@ApiModelProperty(example = "성별")
	private String gender;
	
	@ApiModelProperty(example = "나이")
	private int age;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getPersonPW() {
		return personPW;
	}

	public void setPersonPW(String personPW) {
		this.personPW = personPW;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
