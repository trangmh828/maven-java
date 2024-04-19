package apijava;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnectionExample {

    private static final String GET_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String CONTENT_TYPE = "Content-Type";

    public static void main(String[] args) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
    }
}
