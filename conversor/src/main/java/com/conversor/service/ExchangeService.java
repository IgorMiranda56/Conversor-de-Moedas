package com.conversor.service;

import com.conversor.util.HttpUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExchangeService {

    public double converter(double valor, String from, String to) {
        try {
            String par = from + "-" + to;
            String url = "https://economia.awesomeapi.com.br/json/last/" + par;

            String json = HttpUtil.get(url);

            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();

            // Ex: USDBRL
            String chave = from + to;
            JsonObject dados = obj.getAsJsonObject(chave);

            if (dados == null) {
                System.out.println("Erro: par de moedas não encontrado.");
                return -1;
            }

            double taxa = dados.get("bid").getAsDouble();

            return valor * taxa;

        } catch (Exception e) {
            System.out.println("Erro ao buscar taxa: " + e.getMessage());
            return -1;
        }
    }
}
