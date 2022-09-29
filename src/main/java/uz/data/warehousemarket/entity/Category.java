package uz.data.warehousemarket.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.data.warehousemarket.entity.template.Parent;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Category extends Parent {

    @ManyToOne
    private Category category;

}
