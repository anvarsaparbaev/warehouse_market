package uz.data.warehousemarket.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.data.warehousemarket.entity.template.Parent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Product extends Parent {

    @ManyToOne
    private Category category;

    @OneToOne
    private Attachment photoId;

    @Column(nullable = false,unique = true)
    private String code;

    @ManyToOne
    private Measurement measurement;



}
