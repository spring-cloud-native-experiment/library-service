package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableOAuth2Client
@EnableResourceServer
public class LibraryServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(LibraryServiceApplication.class, args);
    }

    @Bean
    @ConfigurationProperties("security.oauth2.client")
    public ClientCredentialsResourceDetails oAuth2RemoteResource() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    @LoadBalanced
    public OAuth2RestOperations restTemplate(OAuth2ClientContext oAuth2ClientContext) {
        return new OAuth2RestTemplate(oAuth2RemoteResource(), oAuth2ClientContext);
    }
}
