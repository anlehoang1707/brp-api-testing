package api.request;

import api.request.factory.HttpMethodFactory;
import api.request.factory.HttpMethodType;
import io.restassured.response.Response;

import java.io.File;
import java.util.Map;

public class RequestProcessor {
    private String jwtToken;
    private Response response;

    public String getJwtToken() {
        return this.jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Response getResponse() {
        return this.response;
    }

    public void get(String endpoint) {
        HttpRequest httpGet = new HttpMethodFactory().build(HttpMethodType.GET);
        this.response = httpGet.setUrl(endpoint).setToken(jwtToken).request();
    }

    public void get(String endpoint, Map<String ,?extends Object> query) {
        HttpRequest httpGetQuery = new HttpMethodFactory().build(HttpMethodType.GET_WITH_QUERY);
        this.response = httpGetQuery.setUrl(endpoint).setQuery(query).request();
    }

    public void post(String endpoint, File requestPayload) {
        HttpRequest httpPost = new HttpMethodFactory().build(HttpMethodType.POST);
        this.response = httpPost.setUrl(endpoint).setPayload(requestPayload).request();
    }

    public void put(String endpoint, Map<String ,?extends Object> query) {
        HttpRequest httpPut = new HttpMethodFactory().build(HttpMethodType.PUT);
        this.response = httpPut.setUrl(endpoint).setQuery(query).request();
    }

    public void delete(String endpoint, Map<String ,?extends Object>query) {
        HttpRequest httpDelete = new HttpMethodFactory().build(HttpMethodType.DELETE);
        this.response = httpDelete.setUrl(endpoint).setQuery(query).request();
    }
}

