package br.com.rd.ProjetoServico.Model.DTO;

public class CarDTO extends VehicleDTO{
    private Boolean turbine;
    private MediaDTO media;

    public Boolean getTurbine() {
        return turbine;
    }

    public void setTurbine(Boolean turbine) {
        this.turbine = turbine;
    }

    public MediaDTO getMedia() {
        return media;
    }

    public void setMedia(MediaDTO media) {
        this.media = media;
    }
}
