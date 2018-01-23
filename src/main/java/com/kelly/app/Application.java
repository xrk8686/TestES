package com.kelly.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kelly.pojo.TreeNode;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.search.aggregation.TermsAggregation;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by XU on 2017/4/23.
 */

//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
//            printBeanName(ctx);
            JestClient jestClient = (JestClient) ctx.getBean("jestClient");

            Search search = new Search.Builder(getQuery())
                    .addIndex("cars")
                    .addType("transactions")
                    .build();
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
            TermsAggregation aggs1 = result.getAggregations().getTermsAggregation("by_color");

            aggs1.getBuckets().stream().forEach((each) -> {
                System.out.println("Key is:" + each.getKey() + "  Count is:" + each.getCount());
            });
            List<TreeNode> roots = new ArrayList<>();
            for (TermsAggregation.Entry each : aggs1.getBuckets()) {
                TreeNode root = new TreeNode();
                root.setCount(each.getCount());
                String entityName = each.getKey();
                String[] entitys = StringUtils.split(entityName, "_");
                root.setEntityType(entitys[0]);
                root.setEntityId(entitys[1]);
                root.setEntityName(entityName);
                roots.add(root);
                if (each.getTermsAggregation("by_date").getBuckets().size() > 0) {
                    List<TreeNode> subNodes = new ArrayList<>();
                    for (TermsAggregation.Entry subEntry : each.getTermsAggregation("by_date").getBuckets()) {
                        TreeNode subNode = new TreeNode();
                        BeanUtils.copyProperties(root, subNode);
                        subNode.setUpdateDate(new Date(Long.valueOf(subEntry.getKey())));
                        subNode.setCount(subEntry.getCount());
                        subNodes.add(subNode);
                    }
                    root.setSubNodes(subNodes);
                }
            }
            System.out.println("------------TreeNodes are--------------");
            System.out.println(new ObjectMapper().writeValueAsString(roots));


            jestClient.shutdownClient();

        };
    }

    private String getQuery() {
        AggregationBuilder aggrBuilder = AggregationBuilders.terms("by_color")
                .subAggregation(AggregationBuilders.terms("by_date").field("sold"))
                .script(new Script("doc['color'].value+'_'+doc['price'].value"));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(
                QueryBuilders.constantScoreQuery(
                        QueryBuilders.termsQuery("color", "red", "blue", "green")));
        searchSourceBuilder.aggregation(aggrBuilder).size(0);
        String query = searchSourceBuilder.toString();
        System.out.println(query);
        return query;
    }

    private void printBeanName(ApplicationContext ctx) {
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
