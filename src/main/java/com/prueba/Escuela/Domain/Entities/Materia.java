package com.prueba.Escuela.Domain.Entities;

import java.util.Objects;

public class Materia {
    private final int id;
    private final String nombre;
    private final boolean activo;

    public Materia(int id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", activo=" + activo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia)) return false;
        Materia materia = (Materia) o;
        return getId() == materia.getId() && isActivo() == materia.isActivo() && Objects.equals(getNombre(), materia.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), isActivo());
    }
}
