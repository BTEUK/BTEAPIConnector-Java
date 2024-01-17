package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.socials;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Updates all socials for a build team
 */
public class UpdateSocials extends Action
{
    public UpdateSocials()
    {
        super(RequestType.POST);
    }
}
