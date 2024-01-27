package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.claims;

import com.google.gson.Gson;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;
import me.bteuk.bteapiconnectorjava.buildtheearth.objects.Claim;
import me.bteuk.bteapiconnectorjava.buildtheearth.objects.CoordinateOrder;


/**
 * Creates a claim
 */
public class CreateClaim extends Action
{
    private Claim requestArgs;

    /**
     * Initialises and Prepares the CreateClaim action for use.
     * <p>
     *     It will convert the coordinate order to the order required by the API request, and update the string representation of the coordinates
     * </p>
     * @param szTeamID The Build Team ID of the team
     * @param claim The Claim object holding the details for this claim
     * @param bUseSlug Whether the API should interpret the ID as a slug (e.g 'GB' or 'DE') instead of the Build Team ID
     */
    public CreateClaim(String szTeamID, Claim claim, String szAPIKey, boolean bUseSlug)
    {
        super(RequestType.POST, "/public/buildteams/"+szTeamID+"/claims", szAPIKey);

        //Convert coordinates to the correct order
        claim.coordinateOrderSwitcher(CoordinateOrder.LatitudeThenLongitude);
        claim.updateStringArea();

        requestArgs = claim;
    }

    /**
     * Sends a create claim request to the API
     * @param bPrintRequestAndResponseDetails If true, outputs the request and response details (headers and Json content)
     * @return All of the details of the new claim
     */
    public Claim createClaim(boolean bPrintRequestAndResponseDetails)
    {
        //Sends the request and extracts the response
        String szJson = sendRequestReturnString(requestArgs, bPrintRequestAndResponseDetails);

        //Deserialises the response into a new Claim object
        Claim claim = (new Gson()).fromJson(szJson, Claim.class);
        claim.manualCoordinateOrderSetter(CoordinateOrder.LongitudeThenLatitude);
        return claim;
    }

    /**
     * A tester. This will create the London Parks claim
     * @param args
     */
    public static void main(String[] args)
    {
        //The area
        double[][] dArea = {{-0.151356, 51.501841}, {-0.149778, 51.502463}, {-0.149653, 51.503154}, {-0.147826, 51.503951}, {-0.146795, 51.504661}, {-0.142249, 51.506888}, {-0.141343, 51.505731}, {-0.140968, 51.50506}, {-0.14, 51.503971}, {-0.138906, 51.50294}, {-0.131549, 51.505876}, {-0.131299, 51.505614}, {-0.130518, 51.505876}, {-0.129487, 51.505254}, {-0.129221, 51.503679}, {-0.129737, 51.501306}, {-0.140906, 51.500091}, {-0.140593, 51.501083}, {-0.141874, 51.502123}, {-0.14239, 51.502123}, {-0.142936, 51.501899}, {-0.142811, 51.501724}, {-0.144045, 51.50117}, {-0.142558, 51.499636}, {-0.142933, 51.49951}, {-0.143526, 51.499646}, {-0.143855, 51.499189}, {-0.144807, 51.499345}, {-0.144964, 51.499082}, {-0.146807, 51.498343}, {-0.1484, 51.499948}, {-0.151356, 51.501841}};

        //The claim
        //StillSquare: 8fa15150-9079-4dea-8032-a9c748761c65
        //George112n: 159f64f1-5d9c-47e4-abb1-b1bfe5729351
        Claim claim = new Claim("george112n", dArea, CoordinateOrder.LongitudeThenLatitude, true, true, "London Parks", new String[]{"8fa15150-9079-4dea-8032-a9c748761c65"}, "");
        CreateClaim newClaimRequest = new CreateClaim("12c12ef5-ef0b-4e36-ab8f-e54521b0f060", claim, "", false);
        Claim myNewClaim = newClaimRequest.createClaim(true);

        //Takes the claim object and prints it out as a Json
        System.out.println((new Gson()).toJson(myNewClaim));

    }
}
