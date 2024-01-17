package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.claims;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Deletes a claim
 */
public class DeleteClaim extends Action
{
    public DeleteClaim()
    {
        super(RequestType.DELETE);
    }
}
