package me.bteuk.bteapiconnectorjava.buildtheearth.actions.misc;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets your own account information
 */
public class Account extends Action
{
    public Account()
    {
        super(RequestType.GET);
    }
}
