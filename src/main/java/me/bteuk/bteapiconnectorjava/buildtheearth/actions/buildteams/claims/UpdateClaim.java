package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.claims;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Updates a claim
 */
public class UpdateClaim extends Action
{
    public UpdateClaim()
    {
        super(RequestType.POST);
    }
}
