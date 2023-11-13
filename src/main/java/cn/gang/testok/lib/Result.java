package cn.gang.testok.lib;

import lombok.Data;
import okhttp3.Response;

@Data
public class Result {
    Object data;
    Response response;
}
