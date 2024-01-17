package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.claims;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets one claim
 */
public class GetClaim extends Action
{
    public GetClaim()
    {
        super(RequestType.GET);
    }
}
