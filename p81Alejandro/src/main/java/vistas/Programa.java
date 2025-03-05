/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import Modelos.MascotasDAO;
import Modelos.MascotasDTO;
import Modelos.VeterinariosDAO;
import Modelos.VeterinariosDTO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alejandro
 */
public class Programa {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        VeterinariosDAO veterinarios = new VeterinariosDAO();
        List<VeterinariosDTO> listaVeterinario = new ArrayList<>();

        listaVeterinario.add(new VeterinariosDTO(1, "123123", "Alejandro", "asdasd", "5123123", "123123@gmail.com"));
        listaVeterinario.add(new VeterinariosDTO(2, "3213", "Marcos", "asdasd", "1323123", "123123@gmail.com"));
        listaVeterinario.add(new VeterinariosDTO(3, "34523", "Lucas", "asdasd", "1231223", "123123@gmail.com"));
        listaVeterinario.add(new VeterinariosDTO(4, "23432", "Pedro", "asdasd", "1231123", "123123@gmail.com"));
        listaVeterinario.add(new VeterinariosDTO(5, "54423", "Miguel", "asdasd", "1231s23", "123123@gmail.com"));

        veterinarios.insertarVeterinario(listaVeterinario);

        MascotasDAO mascotas = new MascotasDAO();
        List<MascotasDTO> listaMascota = new ArrayList<>();

        listaMascota.add(new MascotasDTO(1, 1, "956245", "Draco", 20.3, LocalDate.of(2023, 1, 12), "perro"));
        listaMascota.add(new MascotasDTO(2, 4, "2342157", "Lucas", 16.2, LocalDate.of(2020, 4, 7), "gato"));
        listaMascota.add(new MascotasDTO(3, 2, "123343", "Daisy", 15.7, LocalDate.of(2022, 9, 19), "gato"));
        listaMascota.add(new MascotasDTO(4, 3, "234234234", "Ruffo", 9.3, LocalDate.of(2024, 5, 27), "pajaro"));
        listaMascota.add(new MascotasDTO(5, 1, "454352", "Boby", 35.9, LocalDate.of(2019, 11, 30), "perro"));

        mascotas.insertarMascota(listaMascota);

        mascotas.insertarMascota(new MascotasDTO(mascotas.getLastInsertedId()+1, 0, "12312755", "Valto", 27.6, LocalDate.of(2021, 8, 18), "perro"));
        System.out.println("------------------Mostrar todos veterinarios-------------------");
        System.out.println(veterinarios.getAll());
        System.out.println("------------------Mostrar todas Mascotas-------------------");
        System.out.println(mascotas.getAll());
        System.out.println("-----------------Actualizar veterinario 5--------------------");
        veterinarios.actualizarVeterinario(5, new VeterinariosDTO(5, "Hola", "Miguel", "asdasd", "1231s23", "123123@gmail.com"));
        System.out.println(veterinarios.findByPk(5));
        System.out.println("-----------------Actualizar Mascota 1--------------------");
        mascotas.actualizarMascota(0, new MascotasDTO(1, 1, "956245", "Paco", 20.3, LocalDate.of(2023, 1, 12), "perro"));
        System.out.println(mascotas.findByPk(1));
        System.out.println("-------------------Ultima Mascota insertada-------------------");
        System.out.println(mascotas.getLastInsertedId());
        System.out.println("-----------------Ultimo Veterinario insertado---------------------");
        System.out.println(veterinarios.getLastInsertedId());
        System.out.println("-----------------Borrado Mascota 2 por id---------------------");
        mascotas.borrarMascota(2);
        System.out.println(mascotas.getAll());
        System.out.println("------------------Borrado mascota 5-------------------");
        mascotas.borrarMascota(new MascotasDTO(5, 1, "454352", "Boby", 35.9, LocalDate.of(2019, 11, 30), "perro"));
        System.out.println(mascotas.getAll());
        System.out.println("------------------Borrado tabla Mascotas--------------------");
        mascotas.borrarMascota();
        System.out.println(mascotas.getAll());
        System.out.println("------------------Borrado Veterinario 2 por id--------------------");
        veterinarios.borrarVeterinario(2);
        System.out.println(veterinarios.getAll());
        System.out.println("-------------------Borrado Veterinario 5-------------------");
        veterinarios.borrarVeterinario(new VeterinariosDTO(5, "54423", "Miguel", "asdasd", "1231s23", "123123@gmail.com"));
        System.out.println(veterinarios.getAll());
        System.out.println("------------------Borrado Tabla Veterinarios--------------------");
        veterinarios.borrarVeterinario();
        System.out.println(veterinarios.getAll());

    }
}
