package me.bteuk.bteapiconnectorjava.buildtheearth;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.io.CloseMode;

import java.io.InputStream;

/**
 * @purpose: Handles all API requests
 * @BTEAPI: The BTE API uses HTTP Post, Get and Delete requests, with JSON request arguments and JSON responses
 */
public class BuildTheEarthAPIHandler
{
    /**
     * A hard coded endpoint for the BTE API
     */
    private static final String szEndPointBase = "https://api.buildtheearth.net/api/v1";

    //TODO: Can headers be a HashTable?

    /**
     * Sends a POST request to the API specified. The authorisation header is automatically added
     * @param szApiKey The API key needed for access to the server. If not needed, leave as "".
     * @param szEndpointUrl The API endpoint url. This is anything after the base, for example, just send "/healthcheck". Do not include the "https://api.buildtheearth.net/api/v1", that is the base
     * @param szRequestArgs The arguments of the request, in a string format representing a JSON
     * @param headers A 2d array of request headers
     * @param bPrintRequestAndResponseDetails If true, outputs the request and response details (headers and Json content)
     * @return The response from the API
     */
    public static BuildTheEarthAPIResponse request(RequestType requestType, String szApiKey, String szEndpointUrl, String szRequestArgs, String[][] headers, boolean bPrintRequestAndResponseDetails)
    {
        //Ensures API key is initialised
        if (szApiKey == null)
            szApiKey = "";

        //Creates the client object
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //----Creates the request----
        //Declares the request builder object
        ClassicRequestBuilder builder;

        switch (requestType)
        {
            case DELETE -> builder = ClassicRequestBuilder.delete(szEndPointBase+szEndpointUrl);
            case GET -> builder = ClassicRequestBuilder.get(szEndPointBase+szEndpointUrl);
            default -> builder = ClassicRequestBuilder.post(szEndPointBase+szEndpointUrl);
        }

        System.out.print("Sending a request at: "+szEndPointBase+szEndpointUrl);

        //Checks to see if an API key was specified
        if (szApiKey.equals(""))
        {
            //No API key was specified, so do not add to request. There is no need to send private information over the internet which isn't even needed
        }
        else
        {
            //An API key was specified, so add to request - Adds the authorisation header
            builder = builder.addHeader("Authorization", "Token "+szApiKey);
        }

        //Adds the request json
        builder = builder.setEntity(szRequestArgs, ContentType.APPLICATION_JSON);

        //Adds any additional headers
        for (int i = 0 ; i < headers.length ; i++)
        {
            builder = builder.addHeader(headers[i][0], headers[i][1]);
        }

        //Builds the request
        ClassicHttpRequest httpRequest = builder.build();

        //Creates the response object
        BuildTheEarthAPIResponse buildTheEarthAPIResponse;

        //Prints out the request headers
        if (bPrintRequestAndResponseDetails)
        {
            System.out.println("\nRequest Headers:");
            for (int i = 0 ; i < httpRequest.getHeaders().length ; i++)
            {
                System.out.println(i +" - " +httpRequest.getHeaders()[i]);
            }
            System.out.println("End of headers");
        }

        //Prints out the request json
        if (bPrintRequestAndResponseDetails)
        {
            System.out.println("\nRequest entity (json):");
            System.out.println(szRequestArgs);
        }

        //Attempt to execute the request
        try
        {
            //Executes the request
            buildTheEarthAPIResponse = httpClient.execute(httpRequest, response ->
            {
                //Declares the response object
                BuildTheEarthAPIResponse buildTheEarthAPIResponse2;

                //Prints the status of the request - should always be 200
                System.out.println("\nBuildTheEarthAPIHandler.request() status of the request: " +response.getCode() + " " + response.getReasonPhrase());

                if (bPrintRequestAndResponseDetails)
                {
                    System.out.println("\nResponse Headers:");
                    for (int i = 0 ; i < response.getHeaders().length ; i++)
                    {
                        System.out.println(i +" - " +response.getHeaders()[i]);
                    }
                    System.out.println("End of headers\n");
                }

                //Extracts the content from the response
                int iCode = response.getCode();
                //TODO: Some error handling
                //If it's not 200 then BTE should send me some lore/reasons in the response

                final HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();

                //Puts the response values into a BuildTheEarthAPIResponse class
                buildTheEarthAPIResponse2 = new BuildTheEarthAPIResponse(response.getReasonPhrase(), content, iCode);
                buildTheEarthAPIResponse2.extractContentInputStreamToString();

                // Ensure it is fully consumed
                EntityUtils.consume(entity);
                return buildTheEarthAPIResponse2;
            });
        }
        catch (Exception e)
        {
            return null;
        }
        finally
        {
            httpClient.close(CloseMode.GRACEFUL);
        }
        return buildTheEarthAPIResponse;
    }

}
