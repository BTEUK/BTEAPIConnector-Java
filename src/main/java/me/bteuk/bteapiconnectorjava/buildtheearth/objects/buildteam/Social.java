package me.bteuk.bteapiconnectorjava.buildtheearth.objects.buildteam;

import lombok.Getter;

/**
 * Stores the variables related to a social. The lombok getters allow read-only access to these variables
 */
public class Social
{
    /**
     * BTE website ID for the social
     */
    @Getter
    private String id;

    /**
     * The name of the social (e.g instagram)
     */
    @Getter
    private String name;

    /**
     * The icon for the social (e.g instagram). See the possible values in the ENUM
     */
    @Getter
    private SocialMediaPlatform icon;

    /**
     * The link to the social's page (e.g "https://www.instagram.com/bte_uk/")
     */
    @Getter
    private String url;

    /**
     * The Build Team ID of the build team which this social belongs to
     */
    @Getter
    private String buildTeamID;
}
