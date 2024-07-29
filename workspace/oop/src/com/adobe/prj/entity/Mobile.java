package com.adobe.prj.entity;

// Mobile IS A Product
public class Mobile extends Product{
    private String connectivity;

    public Mobile() {
        super();
    }

    public Mobile(int id, String name, double price, String connectivity)  {
        super(id, name, price); // to invoke Product(id,name, price);
        this.connectivity = connectivity;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    @Override
    public boolean isExpensive() {
        if("4G".equals(connectivity) && getPrice() > 20000 ) {
            return true;
        } else if("5G".equals(connectivity) && getPrice() > 50000) {
            return true;
        }
        return false;
    }
}
