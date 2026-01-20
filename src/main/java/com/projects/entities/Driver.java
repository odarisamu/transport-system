package com.projects.entities;
import java.io.Serializable;
import java.sql.Date;

public class Driver implements Serializable{
    private Integer id;
    private String cpf;
    private String name;
    private Date birthDate;
    private String licenseDriver;
    private String phone;

    public Driver( ){
        this(null, null, null, null, null);
    }
    public Driver(String cpf, String name, Date birthDate, String licenseDriver, String phone){
        this.id = null;
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.licenseDriver = licenseDriver;
        this.phone = phone;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getLicenseDriver() {
        return licenseDriver;
    }
    public void setLicenseDriver(String licenseDriver) {
        this.licenseDriver = licenseDriver;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Motorista: id = " + id + ", cpf = " + cpf + ", nome = " + name + ", data de nascimento = " + birthDate + ", Carteira de Motorista = "
        + licenseDriver + ", Celular = " + phone;
    }
}
