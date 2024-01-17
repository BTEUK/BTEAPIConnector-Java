package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.claims;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Creates a claim
 */
public class CreateClaim extends Action
{
    public CreateClaim()
    {
        super(RequestType.POST);
    }
}
