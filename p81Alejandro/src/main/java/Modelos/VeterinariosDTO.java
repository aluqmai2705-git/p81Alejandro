/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDate;

/**
 *
 * @author alejandro
 */
public class VeterinariosDTO{
    
    private int idVeterinario;
    private String nif;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public VeterinariosDTO(int pk, String nif, String name, String address,
            String phoneNumber, String email) {
        this.idVeterinario = pk;
        this.nif = nif;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public VeterinariosDTO() {
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("veterinariosDTO{");
        sb.append("pk=").append(idVeterinario);
        sb.append(", nif=").append(nif);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }
}
