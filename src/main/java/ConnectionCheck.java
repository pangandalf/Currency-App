
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;

public class ConnectionCheck {
	
	private static HttpURLConnection connection;
	public int code;
	
	public void connect() {
		try {
			URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/A/");
			connection = (HttpURLConnection) url.openConnection();
			this.code = connection.getResponseCode();
			
			connection.disconnect();
			
		} catch (UnknownHostException e) {
			System.err.println("Host is unavailable!");
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public int getCode() {
		return code;
	}
	
}
