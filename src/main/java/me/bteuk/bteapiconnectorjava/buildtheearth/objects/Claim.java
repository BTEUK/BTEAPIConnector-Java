package me.bteuk.bteapiconnectorjava.buildtheearth.objects;

public class Claim
{
    /**
     * The Build Team ID of the build team which this claim belongs to
     */
    private String buildTeamId;

    /**
     * The name of the owner, e.g "George112n" or "Nudlsupp"
     */
    private String owner;

    /**
     * The coordinates defining the polygon area
     */
    private double[][] dArea;

    /**
     * The coordinate in a string format
     */
    private String[] area;

    /**
     * The order that the coordinates in the area array are stored in
     */
    private CoordinateOrder coordinateOrder;

    /**
     * Where the claim is 'active' or not
     */
    private boolean active;

    /**
     * Whether the claim is 'finished' or not
     */
    private boolean finished;

    /**
     * The name of the area, e.g "Elphilharmonie Hamburg" or "Hyde Park, London"
     */
    private String name;

    /**
     * A list of BTE Website IDs of builders building in this claim
     */
    private String[] builders;

    /**
     * The claim ID
     */
    private String id;

    /**
     * The ID of this claim in an external DB. This may be the ID of the claim in your team's own (probably older) database for example
     */
    private String externalId;

    /**
     * The BTE Website ID of the owner of the claim
     */
    private String ownerId;

    /**
     * Coordinates for the centre of the claim (longitude, latitude)
     */
    private String center;

    /**
     * A timestamp noting when the claim was created
     */
    private String createdAt;

    /**
     * Use when creating a completely new claim
     */
    public Claim(String szOwnerName, double[][] dArea, CoordinateOrder coordinateOrder, boolean bActive, boolean bFinished, String szName, String[] szBuilders, String szExternalID)
    {
        this.owner = szOwnerName;
        this.dArea = dArea;
        this.coordinateOrder = coordinateOrder;
        this.active = bActive;
        this.finished = bFinished;
        this.name = szName;
        this.builders = szBuilders;
        this.externalId = szExternalID;
    }

    /**
     * Use when creating a completely new claim without an owner
     */
    public Claim(double[][] dArea, CoordinateOrder coordinateOrder, boolean bActive, boolean bFinished, String szName, String[] szBuilders, String szExternalID)
    {
        this.dArea = dArea;
        this.coordinateOrder = coordinateOrder;
        this.active = bActive;
        this.finished = bFinished;
        this.name = szName;
        this.builders = szBuilders;
        this.externalId = szExternalID;
    }

    public double[][] getArea(CoordinateOrder requestedCoordinateOrder)
    {
        coordinateOrderSwitcher(requestedCoordinateOrder);
        return dArea;
    }

    /**
     * Switches the order of the coordinates in center and area to the requested order
     */
    public void coordinateOrderSwitcher(CoordinateOrder requestedCoordinateOrder)
    {
        //Switches the coordinates if they are not in the correct order
        if (!requestedCoordinateOrder.equals(this.coordinateOrder))
        {
            int i;
            double dTemp;

            //Handles area
            if (dArea != null)
            {
                for (i = 0 ; i < dArea.length ; i++)
                {
                    //Stores the second one
                    dTemp = dArea[i][1];

                    //Set the second one to the first one
                    dArea[i][1] = dArea[i][0];

                    //Sets the first one to the original second one
                    dArea[i][0] = dTemp;
                }
            }

//            //Handles center
//            if (center != null)
//            {
//                dTemp = center[1];
//                center[1] = center[0];
//                center[0] = dTemp;
//            }

            //Updates the order tracker
            this.coordinateOrder = requestedCoordinateOrder;
        }
    }

    /**
     * Updates the area String[] with the values of the area double[][] array
     */
    public void updateStringArea()
    {
        int i;

        area = new String[dArea.length];

        for (i = 0 ; i < dArea.length ; i++)
        {
            area[i] = dArea[i][0] +", " +dArea[i][1];
        }
    }

    /**
     * Manually sets the coordinate order. You can only use this if no order is currently set
     */
    public void manualCoordinateOrderSetter(CoordinateOrder coordinateOrder)
    {
        if (this.coordinateOrder == null)
        {
            this.coordinateOrder = coordinateOrder;
        }
    }
}
