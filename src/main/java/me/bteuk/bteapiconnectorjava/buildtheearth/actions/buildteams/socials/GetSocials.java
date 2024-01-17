package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.socials;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets a list of all socials for a build team
 */
public class GetSocials extends Action
{
    public GetSocials()
    {
        super(RequestType.GET);
    }
}
