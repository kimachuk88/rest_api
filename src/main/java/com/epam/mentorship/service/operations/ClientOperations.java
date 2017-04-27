package com.epam.mentorship.service.operations;


import com.epam.mentorship.service.model.PostModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Uliana Pizhanska on 25/04/2017.
 */
public class ClientOperations {
    private Client client;
    private ObjectMapper objectMapper;

    public void clientConfig(){
        client = Client.create();
    }

    public ClientResponse getMethod (URI myURI) throws IOException {
        return client.resource(myURI).accept("application/json").get(ClientResponse.class);
    }

    public <T> T retrieveResourceFromResponse(ClientResponse response, Class<T> clazz)
            throws IOException {
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper.readValue(response.getEntity(String.class), clazz);
    }

    public ClientResponse postMethod(URI myURI) throws JsonProcessingException {
        return  client.resource(myURI).type("application/json").post(ClientResponse.class, createResourceJson());
    }


    public String createResourceJson() throws JsonProcessingException {
        PostModel [] postModels = new PostModel[5];
        postModels[0] = new PostModel(1,9494949,"Uliana", "Pizhanska");

        return new ObjectMapper().writeValueAsString(postModels);
    }
}
