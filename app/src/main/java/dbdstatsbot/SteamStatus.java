package dbdstatsbot;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SteamStatus 
{
    private static final String STEAM_API_KEY = "18D3FD27216D77CF6AA3B87E0C31800F";
    public boolean isAPIUp()
	{
		
			String url = "https://api.steampowered.com/ISteamWebAPIUtil/GetServerInfo/v0001/";
			int statusCode = -1;
			try 
			{
				URL steamAPI = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) steamAPI.openConnection();
				connection.setRequestMethod("GET");
				statusCode = connection.getResponseCode();
				connection.disconnect();
			} 
			catch (IOException e) 
			{
				// There was an error connecting to the API
				return false;
			}
			return statusCode >= 200 && statusCode < 300;
	}

    public boolean vanityURL(String vanityURL)
    {
        String url = "https://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key=" + STEAM_API_KEY + "&vanityurl=" + vanityURL;
        int statusCode = -1;
        try
        {
            URL steamAPI = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) steamAPI.openConnection();
            connection.setRequestMethod("GET");
            statusCode = connection.getResponseCode();
            connection.disconnect();
        }
        catch (IOException e)
        {
            // There was an error connecting to the API
            return false;
        }
        return statusCode >= 200 && statusCode < 300;
    }
	
}
