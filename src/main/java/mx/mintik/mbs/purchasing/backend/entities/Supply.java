package mx.mintik.mbs.purchasing.backend.entities;

import mx.mintik.mbs.core.backend.entities.AbstractEntity;
import mx.mintik.mbs.core.backend.entities.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="supplies")
public class Supply extends AbstractEntity {

    public enum Units {
        Pieces,
        Packs,
        Meters,
        Feet,
        Inches,
        Milliliters,
        Liters,
        Gallons,
        FluidOunces,
        Grams,
        Kilograms,
        Pounds
    }

    public enum PackUnits {
        Pieces,
        Meters,
        Feet,
        Inches,
        Milliliters,
        Liters,
        Gallons,
        FluidOunces,
        Grams,
        Kilograms,
        Pounds
    }

    @NotEmpty(message = "Ingrese un número de parte")
    private String partNumber;

    @Column(length = 1024)
    private String description;

    private String brand;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Units units = Units.Pieces;

    private Integer packQuantity;

    private PackUnits packUnits;

    @ManyToOne
    @JoinColumn(name="created_by_id")
    private User createdBy;


    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public Integer getPackQuantity() {
        return packQuantity;
    }

    public void setPackQuantity(Integer packQuantity) {
        this.packQuantity = packQuantity;
    }

    public PackUnits getPackUnits() {
        return packUnits;
    }

    public void setPackUnits(PackUnits packUnits) {
        this.packUnits = packUnits;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
