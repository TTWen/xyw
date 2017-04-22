package rj7.bean;

public class Member extends User {

	private String phone;
	private String email;
	private String age;
	private String sex;
	private String birth;
	private String school;
	private String city; // 现居城市
	private String registtime; // 注册日期 获取系统日期
	private String isrealname; // 是否实名认证  默认值：0
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegisttime() {
		return registtime;
	}
	public void setRegisttime(String registtime) {
		this.registtime = registtime;
	}
	public String getIsrealname() {
		return isrealname;
	}
	public void setIsrealname(String isrealname) {
		this.isrealname = isrealname;
	}
	
}
