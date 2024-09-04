// ExternalApiClient.java
package com.example.hexagonal.infrastructure.feign;

import com.example.hexagonal.domain.model.DataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "externalApiClient", url = "https://api.exemplo.com/v1")
public interface ExternalApiClient {

    // Método que usa parâmetro variável no meio da URL
    @GetMapping("/resource/{param}/details")
    List<DataModel> getData(@PathVariable("param") String param, @RequestParam("filter") String filter);

    // Outro método de exemplo com outro parâmetro variável
    @GetMapping("/items/{type}/info")
    List<DataModel> getDetails(@PathVariable("type") String type, @RequestParam("extra") String extraParam);
}
