package cn.gang.testok.keyword;


import cn.gang.testok.lib.HTTP;
import cn.gang.testok.lib.Result;
import okhttp3.Response;

import java.util.Map;

public class HTTPRequestKeyword {
    public static Result get(String url) {
        Result result = new Result();
        Response response = HTTP.get(url);
        result.setResponse(response);
        return result;
    }

    public static Result get(String url, Map<String, String> headers) {
        Result result = new Result();
        Response response = HTTP.get(url, headers);
        result.setResponse(response);
        return result;
    }
}
