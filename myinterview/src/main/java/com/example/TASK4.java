package com.example;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.services.sso.internal.SsoAccessToken;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;;


/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * AWS s3 bucket => interview-digiage
 *
 */
public class TASK4 {
    public static void main(String[] args) {

        HttpClient httpClient = HttpClients.createDefault();
        String apiUrl = "https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda";
        HttpGet httpGet = new HttpGet(apiUrl);
        
        Map<String, Integer> genderCountMap = new HashMap<>();

        try {
            HttpResponse response = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(response.getEntity());

            System.out.println("Código de status da resposta: " + response.getStatusLine().getStatusCode());
            System.out.println("Corpo da resposta: " + responseBody);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(responseBody);

            if (jsonResponse.has("data") && jsonResponse.get("data").isArray()) {
                JsonNode dataNode = jsonResponse.get("data");

                for (JsonNode record : dataNode) {
                    JsonNode genderNode = record.get("gender");

                    if (genderNode != null && !genderNode.isNull()) {
                        String gender = genderNode.asText();
                        genderCountMap.put(gender, genderCountMap.getOrDefault(gender, 0) + 1);
                    }
                }
            }
                //Exibição do resultado
                System.out.println("Contagem de registro por gênero:");
                for (Map.Entry<String, Integer> entry : genderCountMap.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }

                //Exibir o conteudo do Json para depurar
                System.out.println("Conteúdo do JSON");
                System.out.println(responseBody);

                //Exibir a quantidade de registro para os gêneros M e F.
                int quantidadeFeminino = genderCountMap.getOrDefault("F", 0);
                int quantidadeMasculino = genderCountMap.getOrDefault("M", 0);

                System.out.println("Quantidade de registros para o gênero 'F': " + quantidadeFeminino);
                System.out.println("Quantidade de registro para o gênero 'M': " + quantidadeMasculino);
                
                
                // Exibir o conteúdo do JSON para depuração
                System.out.println("Conteúdo JSON");
                System.out.println(responseBody);

        } catch (IOException e) {
            // tratamento da exceção IOException
            e.printStackTrace();
        }
    }
}