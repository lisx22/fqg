package com.fqg.util;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

public class SolrUtil {
    /**
     * 添加到solr服务器
     * @param commodityId 商品id
     * @param commodityName  商品名字
     */
    public void addDocument(int commodityId,String commodityName){
        HttpSolrClient client=
                new HttpSolrClient
                        .Builder()
                        .withBaseSolrUrl("http://120.79.150.29:8080/mysolr/collection1").build();
        SolrInputDocument document = new SolrInputDocument();

        document.addField("id", "fc00"+commodityId);
        document.addField("commodityId", commodityId+"");
        document.addField("commodityName", commodityName);
        try {
            client.add(document);
            client.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 查询solr
     * @param keyWord 关键字
     * @return 查询出符合关键字的集合
     */
    public SolrDocumentList queryIndex(String keyWord){
        HttpSolrClient client=new
                HttpSolrClient.Builder()
                .withBaseSolrUrl("http://120.79.150.29:8080/mysolr/collection1").build();
        SolrQuery query = new SolrQuery();
        query.setQuery("commodityName:*"+keyWord+"*");
        QueryResponse queryResponse = null;
        System.out.println(keyWord+"关键字");
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

    /**
     * 按id删除solr 服务器里的数据
     * @param commodityId
     */
    public void deleteDocumentByQuery(int commodityId){
        HttpSolrClient client=new HttpSolrClient
                .Builder()
                .withBaseSolrUrl("http://120.79.150.29:8080/mysolr/collection1").build();

        try {
            client.deleteByQuery("commodityId:"+commodityId+"");
            client.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
