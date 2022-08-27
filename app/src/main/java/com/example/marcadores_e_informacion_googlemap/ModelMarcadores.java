package com.example.marcadores_e_informacion_googlemap;

import androidx.annotation.NonNull;

public class ModelMarcadores {

    public String facultad;
    public String decano;
    public String direccion;
    public String logo;
    public double longitud;
    public double latitud;

    public ModelMarcadores(String facultad, String decano, String direccion, String logo, double longitud, double latitud) {
        this.facultad = facultad;
        this.decano = decano;
        this.direccion = direccion;
        this.logo = logo;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%1$s,%2$s,%3$s,%4$s,%5$s", facultad, decano,direccion,logo);
    }
}
