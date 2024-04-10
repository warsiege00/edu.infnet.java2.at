package edu.infnet.clients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LocalidadesClient {

    private static String urlServicoWeb = "https://viacep.com.br/ws/%s/json/";
    public String obterEndereco(String cep){
        String urlFinal = String.format(urlServicoWeb, cep);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlFinal))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                return "Falha ao consumir o serviço da web. Código de status: " + response.statusCode();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Erro ao consumir o serviço da web: " + e.getMessage();
        }
    }
}
