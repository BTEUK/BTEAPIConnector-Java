package me.bteuk.bteapiconnectorjava.buildtheearth.actions.misc;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Checks the health of the API
 */
public class HealthCheck extends Action
{
    public HealthCheck()
    {
        super(RequestType.GET);
    }
}
