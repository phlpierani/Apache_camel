package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class IntegracaoArquivo extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:C:/Users/pedro/Downloads/entrada apache camel")
                .routeId("integracao-arquivo")
                .to("file:C:/Users/pedro/Downloads/saida apache camel");
        // O código acima define uma rota do Apache Camel que lê arquivos de um diretório de entrada e os move para um diretório de saída.
        // A rota é identificada pelo ID "integracao-arquivo".
    }
}
