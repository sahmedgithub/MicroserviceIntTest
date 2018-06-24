package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(value = {Controll.class, DetailsServiceClient.class})
public class DetailsServiceClientTest {

    @Autowired
    private DetailsServiceClient client;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        String detailsString =
                objectMapper.writeValueAsString(new Details("John Smith"));

        this.server.expect(requestTo("https://jsonplaceholder.typicode.com/users/1"))
                .andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON));
    }

    @Test
    public void whenCallingGetUserDetails_thenClientMakesCorrectCall() {

        Details details = this.client.getUserDetails("john");

        assertEquals(details.getName(), "John Smith");
    }
}
