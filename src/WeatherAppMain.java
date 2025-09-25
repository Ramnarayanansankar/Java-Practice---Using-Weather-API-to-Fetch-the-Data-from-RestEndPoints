import org.apache.http.client.utils.URIBuilder;
import java.net.URL;
import java.time.LocalDate;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;


public class WeatherAppMain {

    private static final String API_KEY = "5cb182da483da2dc4a559657e40587b3";

//    public WeatherByDay getWeatherData(String protocol, String host, int port, String path)  {
//        return null;
//    }

// Building the URL here
    public URL getURL(float lat, float lon){
            URL url = null;

        try {
            URIBuilder builder = new URIBuilder("https://api.openweathermap.org/data/3.0/onecall/day_summary");
            LocalDate currentDate = LocalDate.now();
            System.out.println("Current Date: " + currentDate);
            builder.addParameter("lat", String.valueOf(lat));
            builder.addParameter("lon", String.valueOf(lon));
            builder.addParameter("date", currentDate.toString());
            builder.addParameter("appid", API_KEY);
           url = builder.build().toURL();
            System.out.println("URL: " + url);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return url;
    }

//    Calling the RestAPI

    public String callRestAPI(URL fullurl){
        String jsonString= null;

           try {

               HttpURLConnection connection = (HttpURLConnection) fullurl.openConnection();
               connection.setRequestMethod("GET");
               connection.setRequestProperty("Accept", "application/json");
               int responseCode = connection.getResponseCode();
               System.out.println("Response Code: " + responseCode);

               if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                   in.close();
                System.out.println("Response from API:");
                jsonString = response.toString();
                System.out.println(jsonString);


            } else {
                System.out.println("GET request failed.");
            }


           }catch (Exception e) {
            e.printStackTrace();
        }
     return jsonString;
    }

    public String fetchDataFromApi(URL fullurl) {
        String jsonString;
        RestClient restClient = RestClient.create();
        ResponseEntity<String> response = (ResponseEntity<String>) restClient
                .get()
                .uri(String.valueOf(fullurl))
                .retrieve()
                .toEntity(String.class);
                System.out.println(response.getBody());
                jsonString = response.getBody();
        return jsonString;
    }

//    Parsing the JSON here

    public void parseJson(String jsonreturn){

                WeatherByDay day = new WeatherByDay();
                JSONObject latObj = new JSONObject(jsonreturn);
                JSONObject lonObj = new JSONObject(jsonreturn);
                JSONObject tzObj = new JSONObject(jsonreturn);
                JSONObject unitsObj = new JSONObject(jsonreturn);
                day.setLatitude(latObj.getDouble("lat"));
                day.setLongitude(lonObj.getDouble("lon"));
                day.setTimezone(tzObj.getString("tz"));
                day.setUnits(unitsObj.getString("units"));

                System.out.println(day.getLatitude());
                System.out.println(day.getLongitude());
                System.out.println(day.getTimezone());
                System.out.println(day.getUnits());


    }
// Main Block for Calling the Methods

    public static void main(String[] args) {
    WeatherAppMain wam = new WeatherAppMain();
    URL fullurl = wam.getURL(35.4111f,80.8427f);
//    String jsonreturn = wam.callRestAPI(fullurl);
//    wam.parseJson(jsonreturn);
        String jsonreturn = wam.fetchDataFromApi(fullurl);
        wam.parseJson(jsonreturn);

    }

}


