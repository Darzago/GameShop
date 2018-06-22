import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener{

	private static Integer sessionCounter = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		synchronized(sessionCounter)
		{
		sessionCounter ++;
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		synchronized(sessionCounter)
		{
		sessionCounter --;
		}
	}
	
	public static int getActiveSessionCount()
	{
		return sessionCounter;
	}

}
