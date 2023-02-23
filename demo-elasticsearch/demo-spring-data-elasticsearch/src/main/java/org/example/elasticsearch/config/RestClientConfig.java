package org.example.elasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import java.time.Duration;

/**
 * @author taozhu
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    /**
     * 扩展，这里跟repository无关
     * 另外，spring连接ES有两种方式，TransportClient与RestHighLevelClient
     * 目前推荐使用RestHighLevelClient
     *
     * @return
     */
    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
//                .usingSsl()
//                .withProxy("localhost:8888")
//                .withPathPrefix("ela")
                .withConnectTimeout(Duration.ofSeconds(5))
                .withSocketTimeout(Duration.ofSeconds(3))
//                . // ... other options
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
