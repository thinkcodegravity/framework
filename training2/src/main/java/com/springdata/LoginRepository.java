package com.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, String> {

	public List<LoginEntity> findByUidAndPwd(String users,String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE LoginEntity u SET u.pwd=?2 WHERE u.uid= ?1")
	public void update(String users,String password);
	
	@Transactional
	@Modifying
	@Query("DELETE LoginEntity u WHERE u.uid= ?1")
	public void delete(String users);

	/*
	public List<UsersEntity> findByUid(String users);
	
	// JPQL
	@Query("SELECT u FROM UsersEntity u WHERE u.uid= ?1 and u.pwd=?2")
	public List<UsersEntity> verify(String users,String password);
	
	//SQL
	@Query(value="SELECT * FROM users WHERE user= ?1 and password=?2",nativeQuery = true)
	public List<UsersEntity> nativeVerify(String users,String password);
*/		
}
