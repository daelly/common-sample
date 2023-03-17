package com.daelly.common.sample.json;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.util.Map;

public class JSONTest {

    static class Response {
        protected int result;

        protected String msg;

        protected Map<Long, Integer> data;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Map<Long, Integer> getData() {
            return data;
        }

        public void setData(Map<Long, Integer> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "result=" + result +
                    ", msg='" + msg + '\'' +
                    ", data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        String json = "{\"data\":{315317786824875:2,315311372819243:0,315319788126635:2,315321305745205:2,315317636705451:0,315322869833141:2,315321318021557:2,315317869263531:2,315228771658283:0,315336537213995:0},\"msg\":\"处理成功！\",\"result\":0}";
        Gson gson = new Gson();
        Response response = gson.fromJson(json, Response.class);
        System.out.println(response);

        System.out.println(gson.toJson(response));



        Object obj = new Object();
        String gsonStr = JSON.toJSONString(obj);
        System.out.println(gsonStr);
        obj = JSON.parseObject(gsonStr, Object.class);
        System.out.println("--" + obj);
    }
}
