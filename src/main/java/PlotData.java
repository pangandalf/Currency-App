import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;

public class PlotData {
	
	private static HttpURLConnection connection;
	
	PlotGold[] plot = new PlotGold[30];
	
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
			
			int status = connection.getResponseCode();
			System.out.println(status);
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			connection.disconnect();
			//System.out.println(response);
			String responseString = response.toString();
			
			this.plot = new Gson().fromJson(responseString, PlotGold[].class);
			
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getPlot(PlotGold[] plot) {
		for (int i=0; i<30; i++) {
			plot[i] = this.plot[i];
		}
	}
}