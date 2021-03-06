//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package com.dreamsyssoft.aarestdemo.rest;

import java.util.List;
import com.dreamsyssoft.aarestdemo.model.User;
import com.dreamsyssoft.aarestdemo.rest.java.util.List_User;
import org.androidannotations.api.rest.RestErrorHandler;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class UserManager_
    implements UserManager
{

    private RestTemplate restTemplate;
    private String rootUrl;
    private RestErrorHandler restErrorHandler;
    private java.util.HashMap<String, String> availableHeaders;
    private java.util.HashMap<String, String> availableCookies;
    private HttpAuthentication authentication;

    public UserManager_() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        rootUrl = "http://192.168.1.118:3000";
        availableHeaders = new java.util.HashMap<String, String>();
        availableCookies = new java.util.HashMap<String, String>();
    }

    @Override
    public List<User> fetchAllUsers() {
        try {
            return restTemplate.exchange(rootUrl.concat("/users"), HttpMethod.GET, null, List_User.class).getBody();
        } catch (RestClientException e) {
            if (restErrorHandler!= null) {
                restErrorHandler.onRestClientExceptionThrown(e);
                return null;
            } else {
                throw e;
            }
        }
    }

    @Override
    public void updateUser(String id, User user) {
        java.util.HashMap<String, Object> urlVariables = new java.util.HashMap<String, Object>();
        urlVariables.put("id", id);
        HttpEntity<User> requestEntity = new HttpEntity<User>(user);
        try {
            restTemplate.exchange(rootUrl.concat("/users/{id}"), HttpMethod.POST, requestEntity, null, urlVariables);
        } catch (RestClientException e) {
            if (restErrorHandler!= null) {
                restErrorHandler.onRestClientExceptionThrown(e);
            } else {
                throw e;
            }
        }
    }

    @Override
    public void insertUser(User user) {
        HttpEntity<User> requestEntity = new HttpEntity<User>(user);
        try {
            restTemplate.exchange(rootUrl.concat("/users"), HttpMethod.POST, requestEntity, null);
        } catch (RestClientException e) {
            if (restErrorHandler!= null) {
                restErrorHandler.onRestClientExceptionThrown(e);
            } else {
                throw e;
            }
        }
    }

    @Override
    public void deleteUser(String id) {
        java.util.HashMap<String, Object> urlVariables = new java.util.HashMap<String, Object>();
        urlVariables.put("id", id);
        try {
            restTemplate.exchange(rootUrl.concat("/users/{id}"), HttpMethod.DELETE, null, null, urlVariables);
        } catch (RestClientException e) {
            if (restErrorHandler!= null) {
                restErrorHandler.onRestClientExceptionThrown(e);
            } else {
                throw e;
            }
        }
    }

}
