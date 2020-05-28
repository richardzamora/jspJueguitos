package servlets.juego;

import server.server.controlador.EmpresasControlador;
import server.server.controlador.GeneroControlador;
import server.server.dto.JuegosDto;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;

public class VistaJuego {
    private GeneroControlador generoControlador = new GeneroControlador();
    private EmpresasControlador empresasControlador = new EmpresasControlador();

    private int id;
    private String name;
    private String description;
    private String releaseDate;
    private double calification;
    private int empresaId;
    private String empresa;
    private int generoId;
    private String genero;

    public VistaJuego() {
    }
    public VistaJuego(int id, String name, String description, String releaseDate, double calification, int empresaId, int generoId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.calification = calification;
        this.empresaId = empresaId;
        this.generoId = generoId;
    }

    public VistaJuego(JuegosDto juego)
    {
        this.id = juego.getId();
        this.name = juego.getName();
        this.description = juego.getDescription();
        this.releaseDate = juego.getReleaseDate().toString();
        this.calification = juego.getCalification();
        this.empresaId = juego.getEmpresa();
        this.generoId = juego.getGenero();
        setEmpresaGeneroText();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getCalification() {
        return calification;
    }

    public void setCalification(double calification) {
        this.calification = calification;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEmpresaGeneroText()
    {
        empresa = empresasControlador.findById(empresaId).getName();
        genero = generoControlador.findById(generoId).getName();
    }
    public static ArrayList<VistaJuego> pasarJuegos(ArrayList<JuegosDto> juegos)
    {
        ArrayList<VistaJuego> miLista = new ArrayList<>();
        for(int i = 0; i < juegos.size();i++)
        {
            miLista.add(new VistaJuego(juegos.get(i)));
        }
        return miLista;
    }
}
