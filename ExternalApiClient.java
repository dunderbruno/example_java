// ExternalApiClient.java
package com.example.hexagonal.infrastructure.feign;

import com.example.hexagonal.domain.model.DataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "externalApiClient", url = "https://api.externa.com")
public interface ExternalApiClient {

    @GetMapping("/data")
    List<DataModel> getData(@RequestParam("param") String param);

    @GetMapping("/details")
    List<DataModel> getDetails(@RequestParam("type") String type);
}
