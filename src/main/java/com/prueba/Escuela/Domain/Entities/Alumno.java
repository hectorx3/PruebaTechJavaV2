package com.prueba.Escuela.Domain.Entities;

import java.util.Objects;

public class Alumno {
    private final int id;
    private final String nombre;
    private final String apellido_paterno;
    private final String apellido_materno;
    private final boolean activo;

    public Alumno(int id, String nombre, String apellido_paterno, String apellido_materno, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido_paterno='" + apellido_paterno + '\'' +
                ", apellido_materno='" + apellido_materno + '\'' +
                ", activo=" + activo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return getId() == alumno.getId() && isActivo() == alumno.isActivo() && Objects.equals(getNombre(), alumno.getNombre()) && Objects.equals(getApellido_paterno(), alumno.getApellido_paterno()) && Objects.equals(getApellido_materno(), alumno.getApellido_materno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getApellido_paterno(), getApellido_materno(), isActivo());
    }
}
