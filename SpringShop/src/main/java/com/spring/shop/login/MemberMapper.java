package com.spring.shop.login;

public interface MemberMapper {
	
	public int joinMember(Member m); 
	//memberMapper.xml에서 쿼리 실행 후 MemberDAO에 int값으로 DB 연동 유무 전송
	//joinMember == memberMappler.xml의 insert id="joinMember"
	//Member는 파라미터
	
	public Member loginMember(Member m);
	
	public int updateMember(Member m);
	
	public int deleteMember(Member m);
	
	public int idCheck(String id);
}
