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
    
    private int pk;
    private int pk_Veterinario;
    private String chip;
    private String name;
    private double peso;
    private LocalDate fechaNacim;
    private String tipoMascota;

    public MascotasDTO(int pk, int pk_Veterinario, String chip, String name, 
            double peso, LocalDate fechaNacimiento, String tipoMascota) {
        this.pk = pk;
        this.pk_Veterinario = pk_Veterinario;
        this.chip = chip;
        this.name = name;
        this.peso = peso;
        this.fechaNacim = fechaNacimiento;
        this.tipoMascota = tipoMascota;
    }

    public MascotasDTO() {
    }

    public int getPk() {
        return pk;
    }

    public int getPk_Veterinario() {
        return pk_Veterinario;
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
        return tipoMascota;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public void setPk_Veterinario(int pk_Veterinario) {
        this.pk_Veterinario = pk_Veterinario;
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
        this.tipoMascota = tipoMascota;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MascotasDTO{");
        sb.append("pk=").append(pk);
        sb.append(", pk_Veterinario=").append(pk_Veterinario);
        sb.append(", chip=").append(chip);
        sb.append(", name=").append(name);
        sb.append(", peso=").append(peso);
        sb.append(", fechaNacim=").append(fechaNacim);
        sb.append(", tipoMascota=").append(tipoMascota);
        sb.append('}');
        return sb.toString();
    }

    
    
    
}
