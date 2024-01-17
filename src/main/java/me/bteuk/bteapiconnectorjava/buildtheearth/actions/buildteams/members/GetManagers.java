package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.members;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets all of the managers of a build team
 */
public class GetManagers extends Action
{
    public GetManagers()
    {
        super(RequestType.GET);
    }
}

