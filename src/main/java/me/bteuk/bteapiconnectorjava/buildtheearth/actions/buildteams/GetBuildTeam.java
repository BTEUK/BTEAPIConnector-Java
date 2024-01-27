package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams;

import com.google.gson.Gson;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestArgs;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;
import me.bteuk.bteapiconnectorjava.buildtheearth.objects.buildteam.Count;
import me.bteuk.bteapiconnectorjava.buildtheearth.objects.buildteam.Member;
import me.bteuk.bteapiconnectorjava.buildtheearth.objects.buildteam.Showcase;
import me.bteuk.bteapiconnectorjava.buildtheearth.objects.buildteam.Social;

/**
 * Gets a build team
 */
public class GetBuildTeam extends Action
{
    /**
     * The request args
     */
    private GetBuildTeamRequestArgs requestArgs;

    //All of the data sits below here
    public String id;
    public String name;
    public String icon;
    public String backgroundImage;
    public String invite;
    public String about;
    public String creatorId;
    public String createdAt;
    public String location;
    public String slug;
    public String ip;
    public String acceptionMessage;
    public boolean allowTrial;
    public String rejectionMessage;
    public String trialMessage;
    public boolean allowBuilderClaim;
    public boolean allowApplications;
    public boolean instantAccept;
    public String color;
    public Social[] socials;
    public Member[] members;
    public Count _count;
    public Showcase[] showcases;

    /**
     * Initialises and Prepares the GetBuildTeam action for use
     * @param ID The slug or Build Team ID of the team
     * @param bUseSlug Whether the API should interpret the ID as a slug (e.g 'GB' or 'DE') instead of the Build Team ID
     * @param bIncludeShowcases Whether the response should include a list of the Build Team's showcases
     * @param bIncludeMembers Whether the response should include a list of the Build Team's members
     */
    public GetBuildTeam(String ID, boolean bUseSlug, boolean bIncludeShowcases, boolean bIncludeMembers)
    {
        super(RequestType.GET, "/buildteams/"+ID +"?slug=" +bUseSlug +"&showcases=" +bIncludeShowcases +"&members="+bIncludeMembers);
        requestArgs = new GetBuildTeamRequestArgs();
        requestArgs.slug = bUseSlug;
        requestArgs.showcases = bIncludeShowcases;
        requestArgs.members = bIncludeMembers;
    }

    /**
     * Sends a get build teams request to the API and stores the results in another GetBuildTeam object
     * @return Results of the request - the details of a build team. The returned object is of the same type as the request, but it is a unique object
     */
    public GetBuildTeam getBuildTeam(boolean bPrintJson)
    {
        //Sends the request and extracts the response
        String szJson = sendRequestReturnString(requestArgs, bPrintJson);

        //Deserialises the response into an object
        GetBuildTeam getBuildTeam = (new Gson()).fromJson(szJson, GetBuildTeam.class);
        return getBuildTeam;
    }

    /**
     * A tester. This will get the build team information for the BTE UK team
     * @param args
     */
    public static void main(String[] args)
    {
        GetBuildTeam getBuildTeam = new GetBuildTeam("gb", true, false, false);
        GetBuildTeam getBuildTeamResponse = getBuildTeam.getBuildTeam(false);
        System.out.println((new Gson()).toJson(getBuildTeamResponse));
    }
}

class GetBuildTeamRequestArgs extends RequestArgs
{
    /**
     * Determines whether the ID is to be interpreted as a slug
     */
    boolean slug;

    /**
     * Determines whether showcases should be returned
     */
    boolean showcases;

    /**
     * Determines whether members should be returned
     */
    boolean members;
}
