package com.kelly.test;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * Created by XU on 2017/5/30.
 */
public class ESTest {
    public static void main(String[] args) throws IOException {
        AggregationBuilder abuilder = AggregationBuilders.terms("by_country")
                .subAggregation(AggregationBuilders.terms("by_date").field("sold"))
                .script(new Script("doc['color'].value+'_'+doc['price'].value"));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termsQuery("color","red","blue","green"));
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.termsQuery("color","red","blue","green"))
                .should(QueryBuilders.termsQuery("color","red","blue","green"));
        searchSourceBuilder.aggregation(abuilder);
        searchSourceBuilder.size(0);
        searchSourceBuilder.query(queryBuilder);

        System.out.println(abuilder.getName());
//        SearchContextAggregations builder = new SearchContextAggregations();
//        XContentBuilder builder = XContentFactory.jsonBuilder();
//        builder.prettyPrint();
//        abuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);

        System.out.println(searchSourceBuilder.toString());
//        System.out.println(searchSourceBuilder.toString());
    }
}
