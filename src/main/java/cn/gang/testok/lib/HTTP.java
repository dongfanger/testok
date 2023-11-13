package cn.gang.testok.lib;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class HTTP {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public static OkHttpClient client = new OkHttpClient();

    public static Response request(Request.Builder requestBuilder) {
        Request request = requestBuilder.build();

        try (Response response = client.newCall(request).execute()) {
            return response;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Response get(String url) {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);
        return request(requestBuilder);
    }

    public static Response get(String url, Map<String, String> headers) {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            requestBuilder.addHeader(entry.getKey(), entry.getValue());
        }

        return request(requestBuilder);
    }

    public static Response post(String url, Map<String, String> headers, String param) {
        RequestBody body = RequestBody.create(param, JSON);
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(body);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            requestBuilder.addHeader(entry.getKey(), entry.getValue());
        }

        return request(requestBuilder);
    }
}
