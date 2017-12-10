package com.przedwojski.futmarketwatch.services;

import com.przedwojski.futmarketwatch.model.Price;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class PricesService {

    @Value("${fut.prices.resource}")
    private String futPricesResource;

    public Price getPlayerPrice(String baseId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) "
                + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        final ParameterizedTypeReference<Map<Long, Price>> ptr =
                new ParameterizedTypeReference<Map<Long, Price>>(){};

        final ResponseEntity<Map<Long, Price>> re =
                restTemplate.exchange("https://" + futPricesResource + "/18/playerPrices?player=" + baseId,
                        HttpMethod.GET, entity, ptr);

        return re.getBody().entrySet().iterator().next().getValue();
    }

}
