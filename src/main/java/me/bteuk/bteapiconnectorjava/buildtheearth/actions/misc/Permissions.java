package me.bteuk.bteapiconnectorjava.buildtheearth.actions.misc;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets all available permissions
 */
public class Permissions extends Action
{
    public Permissions()
    {
        super(RequestType.GET);
    }
}
