package com.fqg.util;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

public class SolrUtil {
    public SolrDocumentList queryIndex(String keyWord){
        HttpSolrClient client=new
                HttpSolrClient.Builder()
                .withBaseSolrUrl("http://192.168.58.22:8080/solr/collection1").build();
        SolrQuery query = new SolrQuery();
        query.setQuery("commodityName:*"+keyWord+"*");
        QueryResponse queryResponse = null;

        try {
            queryResponse = client.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SolrDocumentList solrDocumentList = queryResponse.getResults();
        System.out.println("查询到的商品数量:" + solrDocumentList.getNumFound());
        for (SolrDocument solrDocument : solrDocumentList) {
            System.out.println( solrDocument.toString());
        }
        return solrDocumentList;
    }
}
