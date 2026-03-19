package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.FileConstants;
import org.springframework.stereotype.Component;

@Component
public class IntegracaoArquivo extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:{{diretorioEntrada}}?delay=5000") // especificado no application.properties, o delay é o tempo de espera entre as verificações do diretório de entrada
                .routeId("integracao-arquivo")           // define um ID para a rota, que pode ser usado para monitoramento e gerenciamento
                .log("Processando o arquivo: ${file:name}")  // loga o nome do arquivo que está sendo processado
                .setHeader(FileConstants.FILE_NAME).simple("${date:now:HHmmss}_${file:name}") // renomeia o arquivo adicionando um timestamp ao nome original
                .to("file:{{diretorioSaida}}");         // especificado no application.properties

        // O código acima define uma rota do Apache Camel que lê arquivos de um diretório de entrada e os move para um diretório de saída.
        // A rota é identificada pelo ID "integracao-arquivo".
    }
}
