package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.claims;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Creates a batch of claims
 */
public class CreateClaimBatch extends Action
{
    public CreateClaimBatch()
    {
        super(RequestType.POST);
    }
}
