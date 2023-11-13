package cn.gang.testok.demo.cases;


import cn.gang.testok.keyword.HTTPRequestKeyword;
import cn.gang.testok.lib.Result;
import org.testng.annotations.Test;

public class DemoTest {
    @Test
    void test() {
        Result result = HTTPRequestKeyword.get("http://httpbin.org/status/200");
        assert result.getResponse().code() == 200;
    }
}
