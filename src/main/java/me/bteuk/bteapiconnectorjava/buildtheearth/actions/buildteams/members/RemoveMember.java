package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.members;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Removes a member from a build team
 */
public class RemoveMember extends Action
{
    public RemoveMember()
    {
        super(RequestType.DELETE);
    }
}
