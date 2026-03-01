package com.felipe.linktrackr_backend.ShortLink;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ShortLinkController {

    private final ShortLinkService service;

    public ShortLinkController(ShortLinkService service){
        this.service = service;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> accessUrl(@PathVariable String code){
        String originalUrl = service.getOriginalUrl(code);
        return ResponseEntity.status(302)
                .location(URI.create(originalUrl))
                .build();
    }

    @PostMapping("/api/links")
    public String getShortCode(@RequestBody String url){
        return service.shortenUrl(url);
    }
}
