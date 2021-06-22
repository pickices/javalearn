package com.liuxinchi.springboot03web.config;


import com.mysql.cj.util.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale locale = Locale.getDefault();
        String language = httpServletRequest.getParameter("language");

        if(!StringUtils.isNullOrEmpty(language)){
            String[] local = language.split("_");
            locale = new Locale(local[0],local[1] );
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
