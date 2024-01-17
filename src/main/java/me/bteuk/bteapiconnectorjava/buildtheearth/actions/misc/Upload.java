package me.bteuk.bteapiconnectorjava.buildtheearth.actions.misc;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Used for uploading an image to the BTE website. You must not use this.
 */
public class Upload extends Action
{
    public Upload()
    {
        super(RequestType.POST);
    }
}
