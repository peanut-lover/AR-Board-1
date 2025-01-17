package arboard.util.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import arboard.common.dao.AbstractDAO;

@SuppressWarnings("unchecked")
@Repository("utilDAO")
public class UtilDAO extends AbstractDAO{

	 
	public List<Map<String,Object>> selectFriendList(Map<String, Object> params){
		return selectList("util.selectFriendList", params); 
	}

	public Map<String, Object> selectUser(Map<String, Object> params) { 
		return (Map<String, Object>) selectOne("util.selectUserToEmail", params);
	}

	public void insertFriendRequest(Map<String, Object> param) {

		insert("util.insertFriendRequest", param);
		
	}
 

	public Object selectRequest(Map<String, Object> param) {
		
		return selectOne("util.selectRequest",param);
	}

 

	public List<Map<String, Object>> selectFriendRequestList(Map<String, Object> param) {
		 
		return selectList("util.selectFriendRequestList", param);
		
	}

	public void insertFriendResponse(Map<String, Object> param) {

		insert("util.insertFriendResponse", param);
		
		
	}
 
	public void updateFriendRelationship(Map<String, Object> param) {
		update("util.updateFriendRelationship",param);
		
	}

	public void deleteFriendRequest(Map<String, Object> param) {
		delete("util.deleteFriendRequest", param);
		
	}

	public void deleteFriend(Map<String, Object> param) {
		delete("util.deleteFriend",param);
		
	}

	public void deleteAllFriend(Map<String, Object> profile) { 
		delete("util.deleteAllFriend",profile);
		
	}

	public Map<String, Object> selectDeviceToken(Map<String, Object> param) {
		
		return (Map<String, Object>) selectOne("util.selectDeviceToken",param);
		
	}
}
