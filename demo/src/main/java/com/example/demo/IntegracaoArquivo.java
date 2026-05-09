package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class IntegracaoArquivo extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:{{diretorioEntrada}}?delay=5000")
                .routeId("integracao-arquivo")
                .log("Processando o arquivo: ${file:name}")
                .choice()
                .when(xpath("{{xpathCnpjTransportadora}}").isEqualTo("1"))
                .to("file:{{diretorioSaida}}?fileName=${date:now:HHmmss}_${file:name}")
                .when(xpath("{{xpathCnpjTransportadora}}").isEqualTo("2"))
                .log("HTTP")
                .otherwise()
                .log("Transportadora nao integrada")
                .end();
    }
}
