package server.day35lesson2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GiphyService {
    private String URL = "http://api.giphy.com/v1/gifs/";
    
    @Value("${GIPHY_API_KEY}")
    private String API_KEY;

    public ResponseEntity<String> getGiphyAPI(String input, Integer limit) {
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromUriString(URL + "search")
                .queryParam("api_key", API_KEY)
                .queryParam("q", input)
                .queryParam("limit", limit)
                .toUriString();
        System.out.println(url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        // use response.getBody to get only required info i.e. using JsonArray, JsonObject, stream
        return response;
    }
}
