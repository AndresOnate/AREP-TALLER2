package edu.escuelaing.arep.app;


import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class APIControllerTest {

    @Test
    public void testConnectToMoviesAPI() throws IOException {
        String expectedResponse = "{\"Title\":\"Inception\",";
        APIController ApiController = new APIController();
        String actualResponse = ApiController.connectToMoviesAPI("Inception");
        assertTrue(actualResponse.contains(expectedResponse));
    }

    @Test
    public void testConnectToMoviesAPIMovieNotExist() throws IOException {
        APIController ApiController = new APIController();
        String actualResponse = ApiController.connectToMoviesAPI("NonExistentMovie");
        assertNull(actualResponse);
    }


}
