package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.stores.ShipStore;

public class ShipSummaryControler {


    private Company company;
    private ShipStore shipStore;

    public ShipSummaryControler() {
        this.company = App.getInstance().getCompany();
        this.shipStore = company.getShipS();
    }

    public String getShipSummary(long mmsi){
        return shipStore.getShipSummary(mmsi);
    }

}
