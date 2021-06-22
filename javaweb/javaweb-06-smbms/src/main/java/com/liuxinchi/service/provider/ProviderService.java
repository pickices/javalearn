package com.liuxinchi.service.provider;


import com.liuxinchi.pojo.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> queryProviderlist(String proCode,String proName);

    boolean insertProvider(Provider provider);
}
