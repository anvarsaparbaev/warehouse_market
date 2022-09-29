package uz.data.warehousemarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.User;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.payload.UserDto;
import uz.data.warehousemarket.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id){
        return userService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody UserDto userDto){
        return userService.add(userDto);
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody UserDto userDto,@PathVariable Integer id){
        return userService.update(userDto,id);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        return userService.deleteById(id);
    }

}
