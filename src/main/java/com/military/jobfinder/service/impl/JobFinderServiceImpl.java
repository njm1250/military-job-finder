package com.military.jobfinder.service.impl;

import com.military.jobfinder.service.JobFinderService;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JobFinderServiceImpl implements JobFinderService {
    private static final Logger logger = LoggerFactory.getLogger(JobFinderServiceImpl.class);

    @Value("${api.service.key}")
    private String SERVICE_KEY;

    @Value("${api.url}")
    private String apiUrl;

    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public String getApiData() throws Exception {
        int numOfRows = 10;
        int pageNo = 1;
        URI uri = buildUri(numOfRows, pageNo);
        HttpRequest request = createHttpRequest(uri);

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 200 && response.statusCode() <= 300){
            return convertXmlToJson(response.body());
        } else {
            throw new Exception("Unexpected response status : " + response.statusCode());
            //TODO: 2023-08-08  Need to add more error handling method
        }
    }

    private URI buildUri(int numOfRows, int pageNo) throws Exception {
        Map<String, String> parameters = Map.of(
                "serviceKey", SERVICE_KEY,
                "numOfRows", String.valueOf(numOfRows),
                "pageNo", String.valueOf(pageNo)
        );

        String params = parameters.entrySet().stream()
                .map(p -> URLEncoder.encode(p.getKey(), StandardCharsets.UTF_8) + "=" + URLEncoder.encode(p.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        return URI.create(apiUrl + "?" + params);
    }

    private HttpRequest createHttpRequest(URI uri) {
        return HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/xml")
                .GET()
                .build();
    }

    private String convertXmlToJson(String xmlResponse) {
        JSONObject jsonResponse = XML.toJSONObject(xmlResponse); // XML to JSON
        logger.info("API call completed successfully.");
        return jsonResponse.toString();
    }
}