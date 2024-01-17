package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.application;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Gets a list of all applications questions for a build team
 */
public class GetQuestions extends Action
{
    public GetQuestions()
    {
        super(RequestType.GET);
    }
}
