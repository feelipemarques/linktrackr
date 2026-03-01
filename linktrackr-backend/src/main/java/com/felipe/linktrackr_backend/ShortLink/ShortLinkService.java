package com.felipe.linktrackr_backend.ShortLink;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShortLinkService {

    private final ShortLinkRepository repository;

    @Value("${linktrackr.default.url}")
    private String host;

    public ShortLinkService(ShortLinkRepository repository) {
        this.repository = repository;
    }

    public String shortenUrl(String url){
        String code = UUID.randomUUID().toString().substring(0, 6);
        ShortLinkEntity shortLink = new ShortLinkEntity();
        shortLink.setOriginalUrl(url);
        shortLink.setShortCode(code);
        repository.save(shortLink);
        return host + code;
    }

    public String getOriginalUrl(String shortCode){
        return repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short code not found: " + shortCode))
                .getOriginalUrl();
    }
}
