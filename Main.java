import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static int size_array = 1;
    public static void main(String[] args) {
        try{
            URL url = new URL("https://api.covidtracking.com/v1/us/daily.json");
            HttpURLConnection conn = (HttpURLConnection)  url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("Ocurrió un error: " + responseCode);
            }else{
                //StringBuilder informationString = new StringBuilder(); You can uncomment this line, will have the information in a single variable
                Scanner sc = new Scanner(url.openStream());
                int i = 0;
                String [] information = new String[size_array];
                while(sc.hasNext()){
                    //informationString.append(sc.nextLine());
                    information[i] = sc.nextLine();
                    System.out.println(information[i]);
                    i++;
                    size_array ++;
                }
                sc.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}