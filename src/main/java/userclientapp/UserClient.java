package userclientapp;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class UserClient {

	public List<UserDTO> getUsers(int page) throws IOException { // adding page as a param sp we can specify the page number
	    String url = String.format("https://reqres.in/api/users?page=%d", page); 

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            String jsonResponse = client.execute(request, httpResponse ->
                EntityUtils.toString(httpResponse.getEntity()));

            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown properties like Avatar which I got an error on
            
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode dataNode = rootNode.path("data");
            // This will map the JSON response to a List of UserDTO objects
            List<UserDTO> users = mapper.readValue(
                    dataNode.toString(),
                    new TypeReference<List<UserDTO>>() {}
                );
            
            return users;
        }
    }

    public static void main(String[] args) {
        UserClient client = new UserClient();
        try {
            List<UserDTO> users = client.getUsers(1); //specifying the page number here but can also be parameterized via command line
            for (UserDTO user : users) {
                System.out.println(user.getFirstName() + " " + user.getLastName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

