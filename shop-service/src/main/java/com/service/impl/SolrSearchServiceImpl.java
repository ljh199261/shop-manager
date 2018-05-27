package com.service.impl;

import com.entity.SolrResult;
import com.entity.User;
import com.service.SolrSearchService;

import java.util.ArrayList;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SolrSearchServiceImpl implements SolrSearchService {
    @Autowired
    private SolrServer solrServer;

    @Override
    public SolrResult solrSearch(String query, int page, int rows) {
        SolrResult result = new SolrResult();
        SolrQuery solrQuery = new SolrQuery();
        //设置查询条件
        solrQuery.setQuery(query);
        //设置分页
        solrQuery.setStart(page);
        solrQuery.setRows(rows);
        //设置高亮
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("username");
        solrQuery.setHighlightSimplePre("<em style=\"color:red\">");
        solrQuery.setHighlightSimplePost("</em>");
        List<User> userList = new ArrayList<>();
        try {
            QueryResponse response = solrServer.query(solrQuery);
            SolrDocumentList solrDocumentList = response.getResults();
            result.setRecordCount(solrDocumentList.getNumFound());
            Map<String,Map<String,List<String>>> highLighting = response.getHighlighting();
            for (SolrDocument solrDocument : solrDocumentList){
                User user = new User();
                user.setId(Integer.parseInt((String) solrDocument.get("id")));
                List<String> list = highLighting.get(solrDocument.get("id")).get("username");
                String username = "";
                if(list!=null&&list.size()>0){
                    username = list.get(0);
                }else {
                    username = (String) solrDocument.get("username");
                }
                user.setUsername(username);
                user.setPassword((String )solrDocument.get("password"));
                userList.add(user);
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        result.setList(userList);
        return result;
    }
}
