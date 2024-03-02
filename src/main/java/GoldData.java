import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GoldData {
	
	private static HttpURLConnection connection;
	
	Float gold;
	
	public void connect() {
		try {
			BufferedReader reader;
			String line;
			StringBuffer response = new StringBuffer();
			URL url = new URL("http://api.nbp.pl/api/cenyzlota");
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			System.out.println(status);
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			connection.disconnect();
			
			String responseString = response.toString();
			JsonArray jsonArray = JsonParser.parseString(responseString).getAsJsonArray();
			String array = (jsonArray.get(0)).toString();
			JsonObject jsonObject = JsonParser.parseString(array).getAsJsonObject();
			this.gold = (jsonObject.get("cena")).getAsFloat();

		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public float getCurrency() {
		return this.gold;
	}
}