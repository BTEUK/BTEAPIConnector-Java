package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets a build team
 */
public class GetBuildTeam extends Action
{
    public GetBuildTeam()
    {
        super(RequestType.GET);
    }
}
