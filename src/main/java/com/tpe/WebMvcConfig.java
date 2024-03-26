package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration // to make this a configuration class
@ComponentScan("com.tpe") //to scan beans from the package specified
@EnableWebMvc // we are telling we will use MVC
public class WebMvcConfig  implements WebMvcConfigurer {

    /**
     * @return to add viewResolver obj as bean
     */
    @Bean
    public InternalResourceViewResolver resolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class); //JavaStandartLibrary --> to write less code inside jsp
        resolver.setPrefix("/WEB-INF/views/"); //indicating location of view files
        resolver.setSuffix(".jsp"); //extensions of view files
        return resolver;
    }

    /**
     * we are setting the location of our resources (css, image, etc)
     * for static resources we do not need to send this to dispatcher servlet
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**") //the path for static files
                .addResourceLocations("/resources/") //this to indicate location
                .setCachePeriod(0); //caching period
    }
}
