package me.bteuk.bteapiconnectorjava.buildtheearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Contains data from a BTE API response
 * Contains util functions for extracting the data
 */
public class BuildTheEarthAPIResponse
{
    private int iCode;
    private String responseReason;
    private InputStream content;
    private String szContent;

    public BuildTheEarthAPIResponse(String responseReason, InputStream content, int iCode)
    {
        this.iCode = iCode;
        this.responseReason = responseReason;
        this.content = content;
    }

    /**
     *
     * @return The HTTP response code of the request
     */
    public int getCode()
    {
        return iCode;
    }

    public String getResponseReason()
    {
        return responseReason;
    }

    public InputStream getContent()
    {
        return content;
    }

    /**
     * Reads the response content from the InputStream into a string if this has not already been done
     * @return The content of the response, as a string
     */
    public String getStringContent()
    {
        if (szContent == null)
            extractContentInputStreamToString();
        return szContent;
    }

    /**
     * Reads the content from the input steam into a string
     * <p>
     * <p> You may then access the data in string for with {@link #getStringContent()}
     */
    public void extractContentInputStreamToString()
    {
        InputStreamReader reader = new InputStreamReader(content);
        BufferedReader br = new BufferedReader(reader);

        String szAllLinesOfContent = readAll(br);

        //Stores the output from reading all lines of the InputStream in a global string variable
        this.szContent = szAllLinesOfContent;
    }

    /**
     * Reads all lines from an InputStream into a String
     * @return The full string content of the InputStream
     */
    private static String readAll(BufferedReader br)
    {
        StringBuilder sb = new StringBuilder("");
        try
        {
            String line;
            line = br.readLine();
            while (line != null)
            {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            sb = new StringBuilder();
        }
        return sb.toString();
    }
}
