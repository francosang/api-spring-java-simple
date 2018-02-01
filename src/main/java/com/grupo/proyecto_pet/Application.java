package com.grupo.proyecto_pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

/**
 * Esta es la clase principal de la aplicacion.
 * Ejecutando el metodo main() iniciamos la aplicacion en un servidor tomcat embebido.
 */
@SpringBootApplication //esta anotacion activa la configuracion del framework Spring
public class Application /*extends SpringBootServletInitializer*/ {

//    @Bean
//    public RequestContextListener requestContextListener() {
//        return new RequestContextListener();
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
