package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.auth.domain.store.ShipStore;

public class ShipSummaryControler {


    private Company company;
    private ShipStore shipStore;

    public ShipSummaryControler() {
        this.company = App.getInstance().getCompany();
        this.shipStore = company.getShipStore();
    }

    public String getShipSummary(long mmsi){
        return shipStore.getShipSummary(mmsi);
    }

}
