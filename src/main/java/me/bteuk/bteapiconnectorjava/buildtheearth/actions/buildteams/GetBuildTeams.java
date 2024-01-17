package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets a list of all Build Teams
 */
public class GetBuildTeams extends Action
{
    public GetBuildTeams()
    {
        super(RequestType.GET);
    }
}
