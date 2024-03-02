import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyData {
	
	private static HttpURLConnection connection;
	
	Currency[] currency = new Currency[33];
	
	public void connect() {
		try {
			BufferedReader reader;
			String line;
			StringBuffer response = new StringBuffer();
			URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/A/");
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
			System.out.println(response);
			String responseString = response.toString();
			JsonArray jsonArray = JsonParser.parseString(responseString).getAsJsonArray();
			String array = (jsonArray.get(0)).toString();
			JsonObject jsonObject = JsonParser.parseString(array).getAsJsonObject();
			String object = (jsonObject.get("rates")).toString();
			
			this.currency = new Gson().fromJson(object, Currency[].class);
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getCurrency(Currency[] currency) {
		for (int i=0; i<33; i++) {
			currency[i] = this.currency[i];
		}
	}
}