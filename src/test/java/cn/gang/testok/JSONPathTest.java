package cn.gang.testok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.testng.annotations.Test;

public class JSONPathTest {
    @Test
    void test() throws JsonProcessingException {
        String textBlock = """
                                {
                    "id":1,
                    "param":"[{\\"page\\": 1, \\"pinList\\":[\\"cekaigang\\"]}]",
                    "ext1":{
                        "a":1,
                        "b":1
                    },
                    "ext2":[
                        1,
                        1,
                        1
                    ],
                    "ext3":{
                        "name":"pytest"
                    }
                }
                """;
        // 创建一个可修改的配置
        Configuration conf = Configuration.defaultConfiguration().addOptions(Option.AS_PATH_LIST);

        // 解析 JSON
        Object jsonObject = conf.jsonProvider().parse(textBlock);

        // 使用 JsonPath 修改值
        JsonPath.parse(jsonObject, conf).set("$.id", 9);

        // 使用 ObjectMapper 把 jsonObject 转换回 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String modifiedJson = objectMapper.writeValueAsString(jsonObject);

        System.out.println(modifiedJson);  // 输出：{"a":{"b":3}}
    }
}
