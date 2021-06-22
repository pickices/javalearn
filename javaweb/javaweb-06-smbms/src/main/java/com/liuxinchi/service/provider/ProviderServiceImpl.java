package com.liuxinchi.service.provider;

import com.liuxinchi.dao.provider.ProviderDao;
import com.liuxinchi.pojo.Provider;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProviderServiceImpl implements ProviderService {

    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Provider> queryProviderlist(String proCode,String proName) {
        ProviderDao mapper = sqlSession.getMapper(ProviderDao.class);
        List<Provider> providerList = mapper.queryProviderList(proCode,proName);
        return providerList;
    }

    @Override
    public boolean insertProvider(Provider provider) {
        boolean flag = false;
        ProviderDao mapper = sqlSession.getMapper(ProviderDao.class);
        if(mapper.insertProvider(provider)>0){
            flag = true;
        }
        return flag;

    }
}
