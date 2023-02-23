package org.example.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.elasticsearch.constants.EsConsts;
import org.example.elasticsearch.constants.FieldAnalyzer;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author taozhu
 */
@Document(indexName = EsConsts.INDEX_NAME, shards = 1, replicas = 0)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 名字
     */
    @Field(type = FieldType.Keyword)
    private String name;

    /**
     * 国家
     */
    @Field(type = FieldType.Keyword)
    private String country;

    /**
     * 年龄
     */
    @Field(type = FieldType.Integer)
    private Integer age;

    /**
     * 生日
     */
    @Field(type = FieldType.Date)
    private Date birthday;

    /**
     * 介绍
     */
    @Field(type = FieldType.Text, analyzer = FieldAnalyzer.IK_MAX_WORD)
    private String remark;
}

