package me.bteuk.bteapiconnectorjava.buildtheearth.actions.misc;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets a list of all claims
 */
public class Claims extends Action
{
    public Claims()
    {
        super(RequestType.GET);
    }
}
