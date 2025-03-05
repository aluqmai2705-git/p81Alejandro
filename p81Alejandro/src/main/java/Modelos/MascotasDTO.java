/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author alejandro
 */
import java.time.LocalDate;

/**
 *
 * @author alejandro
 */
public class MascotasDTO {
    
    private int idMascota;
    private int idVeterinario;
    private String chip;
    private String name;
    private double peso;
    private LocalDate fechaNacim;
    private String tipo;

    public MascotasDTO(int pk, int pk_Veterinario, String chip, String name, 
            double peso, LocalDate fechaNacimiento, String tipoMascota) {
        this.idMascota = pk;
        this.idVeterinario = pk_Veterinario;
        this.chip = chip;
        this.name = name;
        this.peso = peso;
        this.fechaNacim = fechaNacimiento;
        this.tipo = tipoMascota;
    }

    public MascotasDTO() {
    }

    public int getPk() {
        return idMascota;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public String getChip() {
        return chip;
    }

    public String getName() {
        return name;
    }

    public double getPeso() {
        return peso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacim;
    }

    public String getTipoMascota() {
        return tipo;
    }

    public void setPk(int idMascota) {
        this.idMascota = idMascota;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacim = fechaNacimiento;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipo = tipoMascota;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MascotasDTO{");
        sb.append("pk=").append(idMascota);
        sb.append(", pk_Veterinario=").append(idVeterinario);
        sb.append(", chip=").append(chip);
        sb.append(", name=").append(name);
        sb.append(", peso=").append(peso);
        sb.append(", fechaNacim=").append(fechaNacim);
        sb.append(", tipoMascota=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

    
    
    
}
