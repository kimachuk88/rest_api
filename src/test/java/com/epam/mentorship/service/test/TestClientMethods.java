package com.epam.mentorship.service.test;

import com.epam.mentorship.service.model.PostModel;
import com.epam.mentorship.service.operations.ClientOperations;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * Created by Uliana Pizhanska on 25/04/2017.
 */
public class TestClientMethods {
    private ClientOperations client;
    private ClientResponse response;
    final String myURI = "https://jsonplaceholder.typicode.com/";

    @BeforeClass
    public void setUp() {
        client = new ClientOperations();
        client.clientConfig();

    }

    @Test(description = "1.Get all posts \n"
                        + "2.Get post by id \n"
                        + "3.Get post by user id")
    public void getAllPosts(String path, String param) throws IOException {
        try {
            response = client.getMethod(new URI(myURI + path + "/" + param));

        }
        catch(URISyntaxException e){

        }
        Assert.assertEquals(response.getStatus(),200);
        Assert.assertTrue(response.getType().toString().contains("application/json"));
        System.out.println(Arrays.deepToString(client.retrieveResourceFromResponse(response, PostModel[].class)));

    }

    }
