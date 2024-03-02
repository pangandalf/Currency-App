import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PlotDataCurrency {
	
	private static HttpURLConnection connection;
	
	PlotCurrency[] plotCurrency = new PlotCurrency[30];
	
	public void connect(String urlAddr) {
		try {
			BufferedReader reader;
			String line;
			StringBuffer response = new StringBuffer();
			URL url = new URL(urlAddr);
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			//int status = connection.getResponseCode();
			//System.out.println(status);
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			connection.disconnect();
			
			String responseString = response.toString();
			
			JsonObject jsonObject = JsonParser.parseString(responseString).getAsJsonObject();
			String object = (jsonObject.get("rates")).toString();
			
			this.plotCurrency = new Gson().fromJson(object, PlotCurrency[].class);
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getPlotCurrency(PlotCurrency[] plotCurrency) {
		for (int i=0; i<30; i++) {
			plotCurrency[i] = this.plotCurrency[i];
		}
	}
}