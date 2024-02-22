package com.example;

import com.fasterxml.jackson.databind.JsoNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.IOError;
import java.io.IOException;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org. apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * AWS s3 bucket => interview-digiage
 *
 */
public class TASK4 {
    public static void main(String[] args) {

        //criação do cliente HTTP
        HttpClient httpClient = HttpClients.createDefault();

        //definição do endpoint da API
        String apiUrl = "https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda";

        //criação de uma solicitação GET
        HttpGet httpGet = new HttpGet(apiUrl);

        try {
            //executa a soliticação e obtem a resposta
            HttpResponse response = httpClient.execute(httpGet);
            
            // obtem o corpo da resposta como uma string
            String responseBody = EntityUtils.toString(response.getEntity());

            //processa a resposta(analisa, exibe, salva)
            System.out.println("Código de status da resposta: " + response.getStatusLine().getStatusCode());
            System.out.println("Corpo da resposta: " + responseBody);

            
        } catch (IOException e) {
            // tratamento da exceção IOException
            e.printStackTrace();
        }
    }
}