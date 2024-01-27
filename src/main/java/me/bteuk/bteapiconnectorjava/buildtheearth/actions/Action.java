package me.bteuk.bteapiconnectorjava.buildtheearth.actions;

import com.google.gson.Gson;
import me.bteuk.bteapiconnectorjava.buildtheearth.BuildTheEarthAPIHandler;
import me.bteuk.bteapiconnectorjava.buildtheearth.BuildTheEarthAPIResponse;

/**
 * Represents an action/request
 */
public class Action
{
    private RequestType requestType;
    private String szEndpoint;
    private String szApiKey;

    /**
     * Added so that it is easier to test. This is a temporary thing which will be removed once all API actions have been completed and swapped to using the subsequent constructor
     * @param requestType
     */
    public Action(RequestType requestType)
    {
        this.requestType = requestType;
        this.szEndpoint = "";
        this.szApiKey = "";
    }

    /**
     * Use this when the action/request does not require authorisation
     * @param requestType The type of http request: Post, Get or Delete
     * @param szEndpoint The endpoint. This is just the suffix. Example: "/healthcheck". Do not include "https://api.buildtheearth.net/api/v1"
     */
    public Action(RequestType requestType, String szEndpoint)
    {
        this.requestType = requestType;
        this.szEndpoint = szEndpoint;
        this.szApiKey = "";
    }

    /**
     * Use this when the action/request requires authorisation
     * @param requestType The type of http request: Post, Get or Delete
     * @param szEndpoint The endpoint. This is just the suffix. Example: "/healthcheck". Do not include "https://api.buildtheearth.net/api/v1"
     * @param szApiKey The api key used for authentication
     */
    public Action(RequestType requestType, String szEndpoint, String szApiKey)
    {
        this.requestType = requestType;
        this.szEndpoint = szEndpoint;
        this.szApiKey = szApiKey;
    }

    protected String sendRequestReturnString(Object requestArgs, boolean bPrintJson)
    {
        //Converts the request arguments into a json string
        Gson gson = new Gson();
        String szRequestArgs = gson.toJson(requestArgs);

        //Makes the request
        BuildTheEarthAPIResponse APIResponse;
        APIResponse = BuildTheEarthAPIHandler.request(requestType, szApiKey, szEndpoint, szRequestArgs, new String[0][2], bPrintJson);

        int iCode = APIResponse.getCode();

        assert APIResponse != null;

        //Prints the content of the response if console output is desired
        if (bPrintJson)
        {
            System.out.println("Request response entity:");
            System.out.println(APIResponse.getStringContent());
        }

        return APIResponse.getStringContent();
    }
}
