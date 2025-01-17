package arboard.game.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
 
import arboard.game.exception.NoDeviceTokenException; 
import arboard.game.exception.NoGameRoomException;

@ControllerAdvice
public class GameExceptionHandler {

	@ExceptionHandler(value = NoDeviceTokenException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)//400 Bad Request
	public Map<String, Object> NoDeviceTokenException() { 
		Map<String, Object> body = new HashMap<String, Object>();
		Map<String, String> subJSONObject = new HashMap<String, String>();
		subJSONObject.put("message", "no device Token");
		subJSONObject.put("title", "NO_DEVICETOKEN");
		body.put("error", subJSONObject); 
		return body;
	}
	@ExceptionHandler(value = NoGameRoomException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)//400 Bad Request
	public Map<String, Object> NoGameRoomException(NoGameRoomException e) { 
		Map<String, Object> body = new HashMap<String, Object>();
		Map<String, String> subJSONObject = new HashMap<String, String>();
		subJSONObject.put("message", e.gameKey +" Game is not exist");
		subJSONObject.put("title", "NO_GAMEROOM");
		body.put("error", subJSONObject); 
		return body;
	}
}
