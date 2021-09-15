package br.com.rd.ProjetoServico.Model.Entity;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@DiscriminatorValue("car")
@Entity
public class Car extends Vehicle{

    @NotNull(message = "Turbine field is empty")
    @Column(nullable = false) //It's used mainly in the DDL schema metadata generation. This means that if we let Hibernate generate the database schema automatically, it applies the not null constraint to the particular database column
    private Boolean turbine;
    //https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api
    @ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)  // fetch = modo de leitura da base, EAGER para ler diretamente e LAZY para ler pela chamada do método --- orphanRemoval - Se não tem relacionamento, então o dado é exluído
    @JoinColumn(name = "id_media") //Field name in Car table
    private Media media;

    public Boolean getTurbine() {
        return turbine;
    }

    public void setTurbine(Boolean turbine) {
        this.turbine = turbine;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
