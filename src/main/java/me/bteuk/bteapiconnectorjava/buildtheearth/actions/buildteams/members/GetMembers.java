package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.members;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets all of the members of a build team
 */
public class GetMembers extends Action
{
    public GetMembers()
    {
        super(RequestType.GET);
    }
}
