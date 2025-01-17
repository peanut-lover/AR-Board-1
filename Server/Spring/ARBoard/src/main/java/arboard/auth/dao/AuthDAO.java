package arboard.auth.dao;
 

import java.util.Map;

import org.springframework.stereotype.Repository;

import arboard.common.dao.AbstractDAO;

@Repository("authDAO")
public class AuthDAO extends AbstractDAO {
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectUserProfileToEmail(Map<String, Object> map) throws Exception{
	    return (Map<String, Object>) selectOne("auth.selectUserProfileToEmail", map);
	}

	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectUserProfileToId(Map<String, Object> map) {
		 
		return (Map<String, Object>) selectOne("auth.selectUserProfileToId", map);
	}
	public void insertUser(Map<String, Object> map) throws Exception {
		 insert("auth.insertUser", map);
	}


	public void updateUserToken(Map<String, Object> map) {
		
		update("auth.updateToken",map);
	}


	public void deleteUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		delete("auth.deleteUser",map);
		
	}


	public void updateUserImage(Map<String, Object> profile) {
		// TODO Auto-generated method stub

		update("auth.updateUserImage",profile); 
	}


	public void updateUserName(Map<String, Object> profile) { 
		update("auth.updateUserName",profile);  
	}
	 
}
