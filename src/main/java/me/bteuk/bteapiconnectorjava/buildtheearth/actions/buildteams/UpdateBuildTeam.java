package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Updates a Build Team
 */
public class UpdateBuildTeam extends Action
{
    public UpdateBuildTeam()
    {
        super(RequestType.POST);
    }
}
