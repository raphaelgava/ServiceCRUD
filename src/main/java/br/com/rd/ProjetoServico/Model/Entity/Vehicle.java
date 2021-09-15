package br.com.rd.ProjetoServico.Model.Entity;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;

//@MappedSuperclass //classes que herdam veiculo sejam tabelas com os dados de veiculo (colocar entity nas classes filhas e sem entity na classe pai)
@Inheritance(strategy=InheritanceType.JOINED) //gera uma tabela por classe @DiscriminatorColumn(name="type") / @DiscriminatorValue("classe")
@DiscriminatorColumn
@Entity
public class Vehicle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Brand field is empty")
    @Column(nullable = false) //It's used mainly in the DDL schema metadata generation. This means that if we let Hibernate generate the database schema automatically, it applies the not null constraint to the particular database column
    private String brand;
    @NotNull(message = "Model field is empty")
    @Column(nullable = false) //It's used mainly in the DDL schema metadata generation. This means that if we let Hibernate generate the database schema automatically, it applies the not null constraint to the particular database column
    private String model;
    @NotNull(message = "Year field is empty")
    @Column(nullable = false) //It's used mainly in the DDL schema metadata generation. This means that if we let Hibernate generate the database schema automatically, it applies the not null constraint to the particular database column
    private Integer year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
