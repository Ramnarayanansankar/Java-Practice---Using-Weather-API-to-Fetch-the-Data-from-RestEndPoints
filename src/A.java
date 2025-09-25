//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.json.JSONObject;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class WeatherAppMain {
//
//    private String baseUrl = "https://api.openweathermap.org/data/3.0/onecall/day_summary";
//    private String latitude = "39.099724";
//    private String longitude = "-94.578331";
//    private String date = "2020-03-04";
//    private String API_KEY = "5cb182da483da2dc4a559657e40587b3";
//
//    public static void main(String[] args) {
//        WeatherAppMain caller = new WeatherAppMain();
//        caller.callWeatherAPI();
//    }
//    public void callWeatherAPI() {
//        String fullUrl = String.format("%s?lat=%s&lon=%s&date=%s&appid=%s",
//                baseUrl, latitude, longitude, date, API_KEY);
//        String jsonString= null;
//
//        try {
//            URL url = new URL(fullUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Accept", "application/json");
//
//            int responseCode = connection.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
//
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(connection.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//                System.out.println("Response from API:");
//                System.out.println(response.toString());
//                JSONObject responseObj  = new JSONObject(response.toString());
//                WeatherByDay day = new WeatherByDay();
//                JSONObject latObj = new JSONObject(response.toString());
//                JSONObject lonObj = new JSONObject(response.toString());
//                JSONObject tzObj = new JSONObject(response.toString());
//                JSONObject dateObj = new JSONObject(response.toString());
//                JSONObject unitsObj = new JSONObject(response.toString());
//                day.setLatitude(latObj.getDouble("lat"));
//                day.setLongitude(lonObj.getDouble("lon"));
//                day.setTimezone(tzObj.getString("tz"));
//                day.setUnits(unitsObj.getString("units"));
//
//                System.out.println(day.getLatitude());
//                System.out.println(day.getLongitude());
//                System.out.println(day.getTimezone());
//                System.out.println(day.getUnits());
//             JSONObject windObj = responseObj.getJSONObject("wind").getJSONObject("max").getFloat("");
//
//
//            } else {
//                System.out.println("GET request failed.");
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}