package br.com.rd.ProjetoServico.Model.DTO;

public class BikeDTO extends VehicleDTO{
    private Integer cubicCapacity;

    public Integer getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(Integer cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }
}
