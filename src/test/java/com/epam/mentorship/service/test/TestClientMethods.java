package com.epam.mentorship.service.test;

import com.epam.mentorship.service.model.PostModel;
import com.epam.mentorship.service.operations.AdditionalOperations;
import com.epam.mentorship.service.operations.ClientOperations;
import com.epam.mentorship.service.utilities.DataProvd;
import com.sun.jersey.api.client.ClientResponse;
import org.apache.log4j.Logger;
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
    final String MY_URI = "https://jsonplaceholder.typicode.com/posts";
    private Logger log = Logger.getLogger("RC: ");
    private PostModel[] model;
    private AdditionalOperations operations;


    @BeforeClass
    public void setUp() {
        client = new ClientOperations();
        operations = new AdditionalOperations();
        client.clientConfig();
    }

    @Test(description = "1.Get all posts \n"
                        + "2.Get post by id \n"
                        + "3.Get post by user id",dataProviderClass = DataProvd.class, dataProvider = "getPosts")
    public void getAllPosts(String param) throws IOException {
        try {
            response = client.getMethod(new URI(MY_URI + param));
        }
        catch(URISyntaxException e){
            log.error("Wrong URI");
        }
        Assert.assertEquals(response.getStatus(),200);
        Assert.assertTrue(response.getType().toString().contains("application/json"));
        log.info(response.toString());
        model = client.retrieveResourceFromResponse(response, PostModel[].class);
        Assert.assertNotNull(model);
        Assert.assertEquals(model.length, operations.postId(model).size());
        Assert.assertEquals(model.length, operations.countNonNullObj(model));
        System.out.println(Arrays.deepToString(model));
    }

    @Test(description = "1.Add some posts from file")
    public void createPost() throws IOException {
        try {
            response = client.postMethod(new URI(MY_URI));
        }
        catch(URISyntaxException e){
            log.error("Wrong URI");
        }
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatus(),201);
        Assert.assertTrue(response.getType().toString().contains("application/json"));
        log.info(response.toString());
    }

    }
