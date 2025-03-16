package codingup;

import java.io.IOException;

public class Main {

    /*
    * Requete
    *
    * URL url = new URL("http://example.com");
    * HttpURLConnection con = (HttpURLConnection) url.openConnection();
    * con.setRequestMethod("GET");
    *
    * BufferedReader in = new BufferedReader(
    * new InputStreamReader(con.getInputStream()));
    * String inputLine;
    * StringBuffer content = new StringBuffer();
    * while ((inputLine = in.readLine()) != null) {
    *   content.append(inputLine);
    * }
    * in.close();
    *
    * */

    public static void main(String[] args) throws IOException {
        DetectionAsteroide.executer();
    }
}