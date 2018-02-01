package com.grupo.proyecto_pet.shared.dto;

public class HorarioDTO {

    private long id;
    private String desde;
    private String hasta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    @Override
    public String toString() {
        return "HorarioDTO{" +
                "id=" + id +
                ", desde='" + desde + '\'' +
                ", hasta='" + hasta + '\'' +
                '}';
    }
}
