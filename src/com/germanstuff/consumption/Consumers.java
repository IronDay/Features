package com.germanstuff.consumption;

public class Consumers {
    private String name;
    private double consumption;

    //public Consumers(){}

    public Consumers(String name,double consumption)
    {
        this.name = name;
        this.consumption = consumption;
    }

    /*public void setName(String name)
    {
        this.name = name;
    }*/

    public String getName()
    {
        return name;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "Consumers{" +
                "name='" + name + '\'' +
                ", consumption=" + consumption +
                '}';
    }
}
