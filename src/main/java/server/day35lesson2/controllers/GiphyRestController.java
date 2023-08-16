package server.day35lesson2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import server.day35lesson2.service.GiphyService;

@RestController
@RequestMapping("/api")
public class GiphyRestController {

    @Autowired
    private GiphyService giphyService;

    @GetMapping("/search/{input}")
    public ResponseEntity<String> searchGiphy(@PathVariable String input,
            @RequestParam(required = false) Integer limit) {
        if (limit == null) {
            limit = 5;
        }
        return giphyService.getGiphyAPI(input, limit);
    }
}
