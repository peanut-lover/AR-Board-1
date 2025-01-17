package arboard.game.websocket;
 
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler; 


public class TestSocketHandler extends TextWebSocketHandler implements InitializingBean{

	private final Logger logger= LogManager.getLogger(getClass());
	
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	
	public TestSocketHandler(){
		super();
		this.logger.debug("Create SocketHandler instance");
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public void sendMessage(String message){
		for(WebSocketSession session:this.sessionSet){
			if(session.isOpen()){
				try{ 
					//session.sendMessage(new TextMessage(message)); 
					session.sendMessage(new BinaryMessage(message.getBytes()));
					
				}catch ( Exception ignored){
					this.logger.debug("fail to send message",ignored);
				}
			}
		}
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {

		Thread thread = new Thread(){
			int i=0;
			@Override
			public void run(){
				while(true){
					try{
						//sendMessage("send message index"+ i++);
				
						//sendMessage();
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
						break;
					}
				}
			}
		};
		thread.start();
		
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception  {
		super.afterConnectionClosed(session, status);
		
		sessionSet.remove(session);
		this.logger.debug("remove session");
	}
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception { 
		super.afterConnectionEstablished(session);
		sessionSet.add(session);
		this.logger.info("add session!");
		System.out.println("Connection established.");
	}
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		
		logger.debug(message.getPayload().toString());
		
//		ByteBuffer buf = (ByteBuffer) message.getPayload();
//		
//		String msg = new String(buf.array());
//		
//		this.logger.debug("receive message:"+msg);
	}
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
		this.logger.debug("web socket error!",exception);
	}
	@Override
	public boolean supportsPartialMessages() { 
		this.logger.debug("call method!");
		return super.supportsPartialMessages();
	}

}
