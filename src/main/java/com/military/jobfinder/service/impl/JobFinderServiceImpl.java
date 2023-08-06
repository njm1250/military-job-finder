package com.military.jobfinder.service.impl;

import com.military.jobfinder.service.JobFinderService;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JobFinderServiceImpl implements JobFinderService {
    private static final Logger logger = LoggerFactory.getLogger(JobFinderServiceImpl.class);
    private final String SERVICE_KEY = "92dpMWrx/kUoW09ic/OWGP9bwEdw3uLKiG59NGvV1ue1m9HTK/xaLURJGDc8qYHgh6A9SmfJHeBPmiAmZIGYyQ==";
    public String getApiData() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        Map<String, String> parameters = Map.of(
                "serviceKey", SERVICE_KEY,
                "numOfRows", "10",
                "pageNo", "1"
        );
        String params = parameters.entrySet().stream()
                .map(p -> URLEncoder.encode(p.getKey(), StandardCharsets.UTF_8) + "=" + URLEncoder.encode(p.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://apis.data.go.kr/1300000/CyJeongBo/list?" + params))
                .header("Content-Type", "application/xml")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() >= 200 && response.statusCode() <= 300){
            String xmlResponse = response.body();
            JSONObject jsonResponse = XML.toJSONObject(xmlResponse); // XML to JSON
            logger.info("API call completed successfully.");
            return jsonResponse.toString();
        } else {
            throw new Exception("Unexpected response status : " + response.statusCode());
        }
    }
}
