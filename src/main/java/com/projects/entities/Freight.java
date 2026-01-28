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
        this(null, null, null, null, null, null, null, null);
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
    public Freight(Integer id, Integer idDriver, Integer idVehicle, Double value, String placeOrigin, String placeDestiny, 
        Boolean payment, Double weight, String type){
            this.id = id;
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
        String clientPayment = "";
        if(payment){
            clientPayment = "Pago";
        } else{
            clientPayment = "Nao pago";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Frete: ");
        sb.append("\nid = ").append(id);
        sb.append("\nid motorista = ").append(idDriver);
        sb.append("\nid veículo = ").append(idVehicle);
        sb.append("\nvalor = ").append(value);
        sb.append("\norigem = ").append(placeOrigin);
        sb.append("\ndestino = ").append(placeDestiny);
        sb.append("\npagamento = ").append(clientPayment);
        sb.append("\npeso = ").append(weight);
        sb.append("\ntipo = ").append(type);
        sb.append("\n");
        return sb.toString();
    }

    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }
    
}
