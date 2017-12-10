import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yasin.POJO.SCoin;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<SCoin> items = new Gson().fromJson(getOlder(), new TypeToken<ArrayList<SCoin>>() {}.getType());

        for(SCoin item : items){
            System.out.println("item -->" + item.getDate() + " " + item.getValue());

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(item.getDate());
            System.out.println(formatter.format(calendar.getTime()));
        }


/*        JSONArray jsonarray = new JSONArray(getOlder());
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj = jsonarray.getJSONObject(i);
            long a = obj.getInt("date");
            int n = obj.getInt("value");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(a);

            int mYear = calendar.get(Calendar.YEAR);
            int mMonth = calendar.get(Calendar.MONTH);
            int mDay = calendar.get(Calendar.DAY_OF_MONTH);
            System.out.println(n + " " + a + " " + mYear + " " + mMonth + " " + mDay);
        }

*/

    }
    private static String getTicker(){
        String url = "https://devakademi.sahibinden.com/ticker";
        StringBuffer response = new StringBuffer("");
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        }catch (java.net.MalformedURLException e){
            e.printStackTrace();
        }catch (ProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return response.toString();
    }
    private static String getOlder(){
        String url = "https://devakademi.sahibinden.com/history";
        StringBuffer response = new StringBuffer("");
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        }catch (java.net.MalformedURLException e){
            e.printStackTrace();
        }catch (ProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return response.toString();
    }
}
