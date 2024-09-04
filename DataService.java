// DataService.java
package com.example.hexagonal.application.service;

import com.example.hexagonal.domain.model.DataModel;
import com.example.hexagonal.infrastructure.feign.ExternalApiClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    private final ExternalApiClient externalApiClient;

    public DataService(ExternalApiClient externalApiClient) {
        this.externalApiClient = externalApiClient;
    }

    public List<DataModel> getFilteredData(String param) {
        // Consulta a API externa
        List<DataModel> data = externalApiClient.getData(param);

        // Filtra e modifica o JSON para retornar apenas atributos selecionados
        return data.stream()
                   .filter(item -> item.getValue().contains("filterCriteria"))
                   .map(item -> new DataModel(item.getId(), item.getName(), null, null))  // Remove 'value' e 'additionalInfo'
                   .collect(Collectors.toList());
    }

    public List<DataModel> getDetailData(String type) {
        // Consulta a API externa
        List<DataModel> details = externalApiClient.getDetails(type);

        // Filtra e modifica o JSON para retornar apenas atributos selecionados
        return details.stream()
                      .map(item -> new DataModel(item.getId(), null, item.getValue(), null)) // Remove 'name' e 'additionalInfo'
                      .collect(Collectors.toList());
    }
}
