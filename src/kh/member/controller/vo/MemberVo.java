package kh.member.controller.vo;

/**
 * 
 * @author Luminite
 * TEST_MEMBER 테이블을 이용하여
 * 0. 첫화면("/")[index.jsp] include header.jsp - 로그인(login Get)/로그아웃(logout Get) 버튼 토글, nav 내정보 보기(myinfo get) 버튼
 *  * 로그인 화면 - 로그인(Login Post) 버튼 / 회원가입(enroll get)버튼
 * 1. 회원가입("/enroll") - get emroll.jsp, post 회원가입 DB 다녀와서 첫화면으로 이동
 * 회원가입화면 - 회원가입(enroll post)버튼
 * 2. 로그인("/login") -Get login.jsp로 forward, Post 로그인 확인 DB다녀와서 session("lgnss") 등록(이름, email, id) 첫 이동
 * 3. 로그아웃("/logout") -Get 세션만료 후 첫 이동
 * 4. 내정보 보기("/myinfo") - get myinfo.jsp
 * 내정보 보기 화면에서 하단에 수정(/myinfoUpdate get), 탈퇴 버튼
 * 5. 내정보 수정하기("/myinfoupdate")
 * 내정보 보기 수정화면에서 수정(infoupdate post)
 *
 */

public class MemberVo {
//  desc test_member;	
//	------ -------- ------------ 
//	ID     NOT NULL VARCHAR2(15) 
//	PASSWD NOT NULL VARCHAR2(15) 
//	NAME   NOT NULL VARCHAR2(20) 
//	EMAIL           VARCHAR2(30)
	
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
