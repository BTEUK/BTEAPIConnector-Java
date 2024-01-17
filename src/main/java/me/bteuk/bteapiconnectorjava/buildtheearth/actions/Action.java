package me.bteuk.bteapiconnectorjava.buildtheearth.actions;

/**
 * Represents an action/request
 */
public class Action
{
    protected RequestType requestType;

    public Action(RequestType requestType)
    {
        this.requestType = requestType;
    }
}
