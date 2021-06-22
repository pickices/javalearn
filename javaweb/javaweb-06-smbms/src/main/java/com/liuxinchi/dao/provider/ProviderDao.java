package com.liuxinchi.dao.provider;

import com.liuxinchi.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderDao {
    List<Provider> queryProviderList(@Param("proCode")String proCode,@Param("proName") String proName);

    int insertProvider(Provider provider);
}
