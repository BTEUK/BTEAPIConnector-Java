package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.claims;

import com.google.gson.Gson;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;
import me.bteuk.bteapiconnectorjava.buildtheearth.objects.Claim;
import me.bteuk.bteapiconnectorjava.buildtheearth.objects.CoordinateOrder;

/**
 * Deletes a claim
 */
public class DeleteClaim extends Action
{
    /**
     * Initialises and Prepares the DeleteClaim action for use.
     * @param szTeamID The Build Team ID of the team
     * @param szClaimID The Claim ID of the claim you want to delete
     */
    public DeleteClaim(String szTeamID, String szClaimID, String szAPIKey)
    {
        super(RequestType.DELETE, "/public/buildteams/"+szTeamID+"/claims/"+szClaimID, szAPIKey);
    }

    /**
     * Sends a delete claim request to the API
     * @param bPrintRequestAndResponseDetails If true, outputs the request and response details (headers and Json content)
     * @return All of the details of the old claim
     */
    public Claim deleteClaim(boolean bPrintRequestAndResponseDetails)
    {
        //Sends the request and extracts the response
        String szJson = sendRequestReturnString(new Object(), bPrintRequestAndResponseDetails);

        //Deserialises the response into a new Claim object
        Claim claim = (new Gson()).fromJson(szJson, Claim.class);
        claim.manualCoordinateOrderSetter(CoordinateOrder.LongitudeThenLatitude);
        return claim;
    }

    /**
     * A tester. This will delete a claim
     * @param args
     */
    public static void main(String[] args)
    {
        DeleteClaim deleteClaimRequest = new DeleteClaim("12c12ef5-ef0b-4e36-ab8f-e54521b0f060", "f8ae245e-ae2e-4568-8365-79617d01a9c8", "a9f04e07a59f660a014ddc0d7730acf28f97ec5aba");

        Claim oldClaim = deleteClaimRequest.deleteClaim(true);

        //Takes the claim object and prints it out as a Json
        System.out.println((new Gson()).toJson(oldClaim));

    }

}
