package uz.data.warehousemarket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.data.warehousemarket.entity.Warehouse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String firstName;  //Ramazan

    private String lastName;    //Kayipov

    private String phoneNumber;     //918563210

    private String code;        //1da1sda2

    private String password;    //12345Roma

    private boolean active;     //true

    private List<Integer> warehousesId;     //1,3,4,1

}
