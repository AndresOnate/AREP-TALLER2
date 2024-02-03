package edu.escuelaing.arep.app;


/**
 * The `HTMLBuilder` class provides methods for generating HTML responses
 * that can be sent as part of HTTP responses in the context of handling movie information.
 */
public class HTMLBuilder {

    /**
     * Generates an HTML response for the client with a form to search for movie information.
     * The HTML contains the structure for the web client
     *
     * @return A formatted HTML response for the client with a search form.
     */
    public static String httpClientHtml() {
        String outputLine =
                "HTTP/1.1 200 OK\r\n"
                        + "Content-Type:text/html\r\n"
                        + "\r\n"
                        + "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "    <head>\n" +
                        "        <title>Movies Information</title>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "        <style>\n" +
                        "            body {\n" +
                        "                font-family: Arial, sans-serif;\n" +
                        "\t\tflex-direction: column;\n" +
                        "\t\tdisplay: flex;\n" +
                        "                align-items: center;\n" +
                        "                justify-content: center;\n" +
                        "            }\n" +
                        "\n" +
                        "            h1 {\n" +
                        "                color: #333;\n" +
                        "            }\n" +
                        "\n" +
                        "            form {\n" +
                        "                margin-bottom: 20px;\n" +
                        "            }\n" +
                        "\n" +
                        "            label {\n" +
                        "                font-weight: bold;\n" +
                        "            }\n" +
                        "\n" +
                        "            input {\n" +
                        "                padding: 5px;\n" +
                        "            }\n" +
                        "\n" +
                        "            table {\n" +
                        "                width: 100%;\n" +
                        "                border-collapse: collapse;\n" +
                        "                margin-top: 20px;\n" +
                        "            }\n" +
                        "\n" +
                        "            table, th, td {\n" +
                        "                border: 1px solid #ddd;\n" +
                        "            }\n" +
                        "\n" +
                        "            th, td {\n" +
                        "                padding: 10px;\n" +
                        "                text-align: left;\n" +
                        "            }\n" +
                        "\n" +
                        "            tr:nth-child(even) {\n" +
                        "                background-color: #f9f9f9;\n" +
                        "            }\n" +
                        "        </style>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>Get Movie Information</h1>\n" +
                        "        <form action=\"/movies\">\n" +
                        "            <label for=\"title\">Title:</label><br>\n" +
                        "            <input type=\"text\" id=\"title\" name=\"title\"><br><br>\n" +
                        "            <input type=\"button\" value=\"Search\" onclick=\"loadGetMsg()\">\n" +
                        "        </form> \n" +
                        "        <div id=\"getrespmsg\"></div>\n" +
                        "\n" +
                        "        <script>\n" +
                        "            function loadGetMsg() {\n" +
                        "                let nameVar = document.getElementById(\"title\").value;\n" +
                        "                const xhttp = new XMLHttpRequest();\n" +
                        "                xhttp.onload = function() {\n" +
                        "                    const movieData = this.responseText;\n" +
                        "                    buildTableFromJson(movieData);\n" +
                        "                }\n" +
                        "                xhttp.open(\"GET\", \"/movies?name=\"+ encodeURIComponent(nameVar));\n" +
                        "                xhttp.send();\n" +
                        "            }\n" +
                        "\n" +
                        "            function buildTableFromJson(movieData) {\n" +
                        "                const movieObject = JSON.parse(movieData);\n" +
                        "\n" +
                        "                const tableHtml = \"<table border='1'>\" +\n" +
                        "                    buildRowsFromObject(movieObject) +\n" +
                        "                    \"</table>\";\n" +
                        "\n" +
                        "                document.getElementById(\"getrespmsg\").innerHTML = tableHtml;\n" +
                        "            }\n" +
                        "\n" +
                        "            function buildRowsFromObject(obj) {\n" +
                        "                return Object.entries(obj).map(([key, value]) => {\n" +
                        "                    return `<tr><td>${key}</td><td>${formatValue(value)}</td></tr>`;\n" +
                        "                }).join(\"\");\n" +
                        "            }\n" +
                        "\n" +
                        "            function formatValue(value) {\n" +
                        "                if (Array.isArray(value)) {\n" +
                        "                    // Si es una lista, construir una cadena con los elementos de la lista\n" +
                        "                    return \"\" + value.map(formatValue).join(\", \") + \"\";\n" +
                        "                } else if (typeof value === 'object') {\n" +
                        "                    // Si es un objeto, construir una cadena con los elementos del objeto\n" +
                        "                    return \"{\" + Object.entries(value).map(([subKey, subValue]) => `${subKey}: \t\t\t\t${formatValue(subValue)}`).join(\", \") + \"}\";\n" +
                        "                } else {\n" +
                        "                    // Si es un valor simple, mostrar tal cual\n" +
                        "                    return value;\n" +
                        "                }\n" +
                        "            }\n" +
                        "        </script>\n" +
                        "    </body>\n" +
                        "</html>";
        return outputLine;
    }


    /**
     * Generates an HTTP response for a 400 Not Found
     *
     * @param title The title of the movie that was not found.
     * @return An HTTP response string for a 400 Not Found error.
     */
    public static String httpError(String title) {
        String outputLine = "HTTP/1.1 400 Not Found\r\n"
                + "Content-Type:application/json\r\n"
                + "\r\n"
                + "{ \"Not Found\": \"" + title + " movie not found\"}";
        return outputLine;
    }

    /**
     * Generates an HTTP response for successful movie data retrieval with the provided JSON string.
     *
     * @param movieJSON The JSON string containing information about the movie.
     * @return An HTTP response string for successful movie data retrieval.
     */
    public static String httpMovieData(String movieJSON){
        String outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + movieJSON;
        return outputLine;
    }

}
