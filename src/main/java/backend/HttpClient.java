package backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class HttpClient {
    private OkHttpClient client;
    public String baseURI;


    public HttpClient(String baseURL) {
        this.client = new OkHttpClient();
        this.baseURI = Helpers.normalizeBaseURL(baseURL);
    }

//    public <T> T getOne(String url, Class<T> tClass) throws IOException {
//        Request request = new Request.Builder()
//                .url(this.baseURI + url)
//                .get()
//                .build();
//
//        Response response = this.client.newCall(request).execute();
//        if (response.isSuccessful()) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            return objectMapper.readValue(response.body().string(), tClass);
//        } else throw new RuntimeException("Unexpected code " + response);
//    }

    public <T> T getOne(String url, Class<T> tClass) throws IOException{
        return getOne(URI.create(this.baseURI + url), tClass);
    }

    public <T> T getOne(URI fullURL, Class<T> tClass) throws IOException{
        Request request = new Request.Builder()
                .url(fullURL.toURL())
                .get()
                .build();
        Response response = this.client.newCall(request).execute();
        if(response.isSuccessful()){
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body().string(), tClass);
        } else throw new RuntimeException("Unexpected Code: "  + response);
    }

    public List<String> getList(URI fullURL) throws IOException{
        Request request = new Request.Builder()
                .url(fullURL.toURL())
                .get()
                .build();
        try (Response response = this.client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(
                        response.body().string(),
                        new TypeReference<List<String>>() {}
                );
            } else {
                throw new RuntimeException("Unexpected Code: " + response);
            }
        }
    }
}
