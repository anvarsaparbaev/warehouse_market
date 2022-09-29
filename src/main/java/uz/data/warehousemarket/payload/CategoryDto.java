package uz.data.warehousemarket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String categoryName;

    private boolean active;

    private Integer categoryId;

}
