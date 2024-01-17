package me.bteuk.bteapiconnectorjava.buildtheearth.actions.buildteams.application;

import me.bteuk.bteapiconnectorjava.buildtheearth.actions.Action;
import me.bteuk.bteapiconnectorjava.buildtheearth.actions.RequestType;

/**
 * Updates all application questions for a build team
 */
public class UpdateQuestions extends Action
{
    public UpdateQuestions()
    {
        super(RequestType.POST);
    }
}
