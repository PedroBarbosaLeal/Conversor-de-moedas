
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conectar {
    double infoMoeda = 0;
    double infoMoeda2 = 0;

    public void conectarClient(String valor, String valor2) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String end = "https://v6.exchangerate-api.com/v6/bd6eaba2d81bb6406c5b855b/latest/" + valor;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(end))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        double moeda = rates.get(valor).getAsDouble();
        infoMoeda = moeda;
        double moeda2 = rates.get(valor2).getAsDouble();
        infoMoeda2 = moeda2;
        System.out.println("Cotação "+valor + ": " + moeda);
        System.out.println("Cotação "+valor2 + ": " + moeda2);

    }

    public double converterMoeda(double valor){
        infoMoeda=valor;
        return infoMoeda*infoMoeda2;
    }


}
