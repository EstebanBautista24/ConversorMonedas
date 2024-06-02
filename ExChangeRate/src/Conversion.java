import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversion {
    private Moneda moneda;
    private MonedaR monedaR;
    HttpClient  cliente;
    HttpRequest request;
    HttpResponse<String> respuesta;
    public Conversion(Moneda moneda) {
        this.moneda = moneda;
        cliente = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/ccafe7c97f8770bdc235d38d/pair/"+moneda.getBase()+"/"+moneda.getConversion()+"/"+moneda.getValor()))
                .build();
        obtenerRespuesta();

    }
    public void obtenerRespuesta() {

        try {
            respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            monedaR = gson.fromJson(respuesta.body(),MonedaR.class);
            moneda = new Moneda(monedaR,moneda.getValor());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public MonedaR getMonedaR() {
        return monedaR;
    }

    public void setMonedaR(MonedaR monedaR) {
        this.monedaR = monedaR;
    }


}
