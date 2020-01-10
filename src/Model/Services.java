/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package Model;

/**
 *
 * @author riku
 */
public class Services {
    private int service_id;
    private String name;
    private float charge;
    
    public Services(int services,String name,float charge){
        this.service_id=service_id;
        this.name=name;
        this.charge=charge;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }
    
    
}
