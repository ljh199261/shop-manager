package com.service;

import com.entity.SolrResult;

public interface SolrSearchService {
    /**
     * 查询索引库
     * @param query
     * @param page
     * @param rows
     * @return
     */
    SolrResult solrSearch(String query,int page,int rows);
}
