package com.service.impl;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.SolrImportService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolrImportServiceImpl implements SolrImportService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SolrServer solrServer;

    @Override
    public void importSolr() {
        List<User> userList= userMapper.selectAll();
        //创建一个SolrInputDocument对象
        try {
            if (userList.size()>0){
                for (User  user : userList){
                    SolrInputDocument document = new SolrInputDocument();
                    //具体的业务逻辑
                    document.setField("id",user.getId());
                    document.setField("username",user.getUsername());
                    document.setField("password",user.getPassword());
                    solrServer.add(document);
                    solrServer.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
