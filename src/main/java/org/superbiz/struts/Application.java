package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public FilterRegistrationBean strutsPrepareAndExecuteFilter() {

        List<String> urlList = new ArrayList<>();
        urlList.add("/*");

        FilterRegistrationBean strutsPrepareAndExecuteFilter = new FilterRegistrationBean();
        strutsPrepareAndExecuteFilter.setFilter(new StrutsPrepareAndExecuteFilter());
        strutsPrepareAndExecuteFilter.addInitParameter("actionPackages", "com.lq");
        strutsPrepareAndExecuteFilter.setOrder(1);
        strutsPrepareAndExecuteFilter.setName("struts2");
        strutsPrepareAndExecuteFilter.setUrlPatterns(urlList);


        return strutsPrepareAndExecuteFilter;
    }


    @Bean
    public FilterRegistrationBean siteMeshFilter(){
        List<String> urlList = new ArrayList<>();
        urlList.add("/*");
        FilterRegistrationBean siteMeshFilter = new FilterRegistrationBean();
        siteMeshFilter.setFilter(new SiteMeshFilter());
        siteMeshFilter.setOrder(0);
        siteMeshFilter.setName("sitemesh");
        siteMeshFilter.setUrlPatterns(urlList);

        return siteMeshFilter;


    }

}