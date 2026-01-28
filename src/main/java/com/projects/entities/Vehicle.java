package com.projects.entities;

import java.io.Serializable;

public class Vehicle implements Serializable{
    private Integer id;
    private String truckSign;
    private Double maxWeight;
    private Integer numberAxles;

    public Vehicle( ){
        this(null, null, null);
    }
    public Vehicle(String truckSign, Double maxWeight, Integer numberAxles){
        this.id = null;
        this.truckSign = truckSign;
        this.maxWeight = maxWeight;
        this.numberAxles = numberAxles;
    }
        public Vehicle(Integer id, String truckSign, Double maxWeight, Integer numberAxles){
        this.id = id;
        this.truckSign = truckSign;
        this.maxWeight = maxWeight;
        this.numberAxles = numberAxles;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTruckSign() {
        return truckSign;
    }
    public void setTruckSign(String truckSign) {
        this.truckSign = truckSign;
    }
    public Double getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }
    public Integer getNumberAxles() {
        return numberAxles;
    }
    public void setNumberAxles(Integer numberAxles) {
        this.numberAxles = numberAxles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Veículo: ");
        sb.append("\nid = ").append(id);
        sb.append("\nplaca = ").append(truckSign);
        sb.append("\npeso máximo = ").append(maxWeight);
        sb.append("\nnúmero de eixos = ").append(numberAxles);
        sb.append("\n");
        return sb.toString();
    }

    
}
