import static java.lang.System.out;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;

public class ModuleExample{

    public static void main(String[] args) throws Exception{
        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("https://reqres.in/api/users/1"))
            .build();
        var response = client.send(request, BodyHandlers.ofString());
        out.printf("Response code: %d %n", response.statusCode());
        out.printf("Response body: %s %n", response.body());
    }
}