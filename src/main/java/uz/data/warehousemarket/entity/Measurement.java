package uz.data.warehousemarket.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.data.warehousemarket.entity.template.Parent;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Measurement extends Parent {


}
