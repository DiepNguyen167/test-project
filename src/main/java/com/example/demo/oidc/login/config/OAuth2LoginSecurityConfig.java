package com.example.demo.oidc.login.config;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.Cookie;

@Configuration
@EnableWebSecurity
public class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Set<String> googleScopes = new HashSet<>();
        googleScopes.add("https://www.googleapis.com/auth/userinfo.email");
        googleScopes.add("https://www.googleapis.com/auth/userinfo.profile");

        OidcUserService googleUserService = new OidcUserService();
        googleUserService.setAccessibleScopes(googleScopes);

        http.cors().and().csrf().disable()
                .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .oauth2Login(oauthLogin -> oauthLogin.userInfoEndpoint().oidcUserService(googleUserService)).oauth2Login()
                .defaultSuccessUrl("/upload", true).permitAll();

    }
}