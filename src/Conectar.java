
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conectar {

        public void conectarClient(String valor) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();

            String end = "https://v6.exchangerate-api.com/v6/bd6eaba2d81bb6406c5b855b/latest/"+valor;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(end))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            System.out.println(json);


            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

            double moeda = rates.get(valor).getAsDouble();
            System.out.println("USD: $"+ moeda);

        }

}
