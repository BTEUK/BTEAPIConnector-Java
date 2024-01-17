package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.socials;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Deletes a social for a build team
 */
public class DeleteSocial extends Action
{
    public DeleteSocial()
    {
        super(RequestType.DELETE);
    }
}
