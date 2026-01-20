package com.projects.entities;
import java.io.Serializable;

public class Freight implements Serializable{
    private Integer id;
    private Integer idDriver;
    private Integer idVehicle;
    private Double value;
    private String placeOrigin;
    private String placeDestiny;
    private Boolean payment;
    private Double weight; //verificar se o veiculo suporta o peso da carga
    private String type;

    public Freight( ){

    }
    public Freight(Integer idDriver, Integer idVehicle, Double value, String placeOrigin, String placeDestiny, Boolean payment,
        Double weight, String type){
            this.id = null;
            this.idDriver = idDriver;
            this.idVehicle = idVehicle;
            this.value = value;
            this.placeOrigin = placeOrigin;
            this.placeDestiny = placeDestiny;
            this.payment = payment;
            this.weight = weight;
            this.type = type;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public String getPlaceOrigin() {
        return placeOrigin;
    }
    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }
    public String getPlaceDestiny() {
        return placeDestiny;
    }
    public void setPlaceDestiny(String placeDestiny) {
        this.placeDestiny = placeDestiny;
    }
    public Boolean getPayment() {
        return payment;
    }
    public void setPayment(Boolean payment) {
        this.payment = payment;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Frete: ");
        sb.append("id = ").append(id);
        sb.append(", id motorista = ").append(idDriver);
        sb.append(", id veículo = ").append(idVehicle);
        sb.append(", valor = ").append(value);
        sb.append(", origem = ").append(placeOrigin);
        sb.append(", destino = ").append(placeDestiny);
        sb.append(", pagamento = ").append(payment);
        sb.append(", peso = ").append(weight);
        sb.append(", tipo = ").append(type);
        return sb.toString();
    }
    
}
