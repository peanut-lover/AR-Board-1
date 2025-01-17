package arboard.auth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import arboard.auth.exception.AccessTokenInvalidException;
import arboard.auth.exception.AccessTokenNotFoundException;
import arboard.auth.exception.InvalidDomainException;
import arboard.auth.exception.SessionUnAuthorizedException;
import arboard.auth.exception.UnKnownException;
import arboard.auth.service.AuthService; 
 

@Controller
public class AuthController {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "authservice")
	private AuthService authService;

	// valify oauthToken and get User Profile and make user session(attribute add - userProfile , status  ) 
	// URI GET /auth/facebook/login? access_token ={access_token} 
	@RequestMapping(value = "/auth/facebook/login", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object FaceBooklogin(@RequestParam(value="access_token",required=false) String accessToken,  HttpSession session) throws Exception {
		 
		if (accessToken == null) { 
			throw new AccessTokenNotFoundException();
		}
		
		//valify token
		String oauthToken = accessToken.toString();
		try{
			if (authService.valifyAccessToken(oauthToken) == false) { 
				throw new AccessTokenInvalidException();
			}
		}catch (AccessTokenInvalidException e){
			e.setSession(session);
			throw e;
		} 
		//Login profile generate (userName,userEmail,oauthToken,oauthType)
		Map<String, Object> profile = authService.reqFacebookProfile(oauthToken);
		profile.put("oauthToken", oauthToken);
		profile.put("oauthType", "facebook"); 
		//Login recently information update or insert.
		Map<String, Object> userProfile = authService.getUserInfo(profile);

		//Session Information Setting.
		session.setAttribute("status",true);
		session.setAttribute("userProfile", userProfile);
		
		return userProfile;
	}
	
//  new login API
//	{
//		oauthDomain : "FACEBOOK 멍청아",
//		oauthToken: "qwdwqdqwd",
//		deviceToken : "wqdwqdwqdqwdwq"
//		}
	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object login(
			@RequestParam(value="oauthDomain",required=false) String oauthDomain,
			@RequestParam(value="oauthToken",required=false) String oauthToken,
			@RequestParam(value="deviceToken",required=false) String deviceToken,
			HttpSession session) throws Exception {
		 
		if (oauthToken == null && oauthDomain == null) { 
			throw new AccessTokenNotFoundException();
		}
		
		//VALIFY OAUTH TOKEN
		try{
			if (authService.valifyAccessToken(oauthToken) == false) { 
				throw new AccessTokenInvalidException();
			}
		}catch (AccessTokenInvalidException e){
			e.setSession(session);
			throw e;
		} 
		
		Map<String, Object> profile ; 
		//Login profile generate (userName,userEmail,oauthToken,oauthDomain,deviceToken) 
		if(oauthDomain.equals("facebook")){
			profile = authService.reqFacebookProfile(oauthToken); 
		}else{
			throw new InvalidDomainException();
		} 
		
		profile.put("oauthToken", oauthToken);
		profile.put("oauthType", oauthDomain); 
		profile.put("deviceToken", deviceToken);
		//Login recently information update or insert.
		Map<String, Object> userProfile = authService.getUserInfo(profile);

		//Session Information Setting.
		session.setAttribute("status",true);
		session.setAttribute("userProfile", userProfile);
		
		return userProfile;
	}
	
	
	// DELETE /user 
	//Description : delete user. 
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object userDelete(HttpSession session) throws Exception {
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> profile = (Map<String, Object>) session.getAttribute("userProfile");
		authService.userDelete(profile);
		
		result.put("delete", profile.get("userEmail"));
		
		return result;
	}
	// DELETE /logout
	//Description : logout current session.

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void logout(HttpSession session)  {

		Map<String,Object> profile = (Map<String, Object>) session.getAttribute("userProfile");
		if(profile == null){ 
			throw new SessionUnAuthorizedException(session);
		}
		Map<String,Object> result = new HashMap<String, Object>();
		session.removeAttribute("userProfile");
		session.removeAttribute("status");
		session.invalidate(); 
	}
	
	// GET /profile
	// Description : get user profile.
	
	
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object changeUserName(@RequestParam(value="userName",required=false) String newName,HttpSession session) throws Exception {
		
		Map<String,Object> profile = (Map<String, Object>) session.getAttribute("userProfile"); 
		
		if(profile == null){ 
			throw new SessionUnAuthorizedException(session);
		} 
		if(newName == null){
			throw new UnKnownException();
		}
  
		profile.put("userName",newName); 
		
		authService.changeUserName(profile); 
		
		return profile;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getprofile(HttpSession session) throws Exception {
		
		Map<String,Object> profile = (Map<String, Object>) session.getAttribute("userProfile");
		if(profile == null){ 
			throw new SessionUnAuthorizedException(session);
		}
		Map<String, Object> userProfile = authService.getUserInfo(profile); 
		return userProfile;
	}
}

////test profile
//profile = new HashMap<String,Object>();
//profile.put("userId", "999");
//profile.put("userName", "Tester");
//profile.put("userEmail", "test@arboard.com");
//profile.put("userImage", null);

