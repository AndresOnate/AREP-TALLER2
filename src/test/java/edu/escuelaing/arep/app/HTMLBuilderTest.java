package edu.escuelaing.arep.app;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class HTMLBuilderTest {

    @Test
    public void testBuildHttpMovieData() {
        String movieJSON = "{\"title\":\"Inception\",\"year\":2010,\"genre\":\"Sci-Fi\"}";
        String result = HTMLBuilder.httpMovieData(movieJSON);
        assertTrue(result.contains("Inception"));
        assertTrue(result.contains("2010"));
        assertTrue(result.contains("Sci-Fi"));
    }

    @Test
    public void testBuildHttpError() {
        String title = "NonExistentMovie";
        String result = HTMLBuilder.httpMovieError(title);
        assertTrue(result.contains("Not Found"));
        assertTrue(result.contains(title));
    }


}
