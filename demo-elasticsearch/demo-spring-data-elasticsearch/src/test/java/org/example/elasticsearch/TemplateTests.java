package org.example.elasticsearch;

import org.example.elasticsearch.model.Person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * @author taozhu
 */
@SpringBootTest
public class TemplateTests {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 测试 ElasticTemplate 创建 index
     */
    @Test
    public void testCreateIndex() {
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(Person.class);

        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchTemplate.putMapping(Person.class);
    }

    /**
     * 测试 ElasticTemplate 删除 index
     */
    @Test
    public void testDeleteIndex() {
        elasticsearchTemplate.deleteIndex(Person.class);
    }
}
