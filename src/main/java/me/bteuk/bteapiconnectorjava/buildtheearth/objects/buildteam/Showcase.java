package me.bteuk.bteapiconnectorjava.buildtheearth.objects.buildteam;

import java.util.UUID;

public class Showcase
{
    /**
     * The ID of the showcase
     */
    private UUID id;

    /**
     * The name of the showcase (e.g: Empire State Building)
     */
    private String name;

    /**
     * A url to the image
     */
    private String image;

    /**
     * A timestamp to when the showcase was created
     */
    private String createdAt;

    /**
     * The Build Team ID of the build team which this showcase belongs to
     */
    private String buildTeamID;
}
