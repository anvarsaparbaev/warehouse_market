package uz.data.warehousemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Measurement;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result addMeasurement(@RequestBody Measurement measurement){
        return measurementService.addMeasurement(measurement);
    }

    @GetMapping
    public List<Measurement> getAllMeasurement(){
        return measurementService.getAllMeasurements();
    }
    @GetMapping("/{id}")
    public Measurement getMeasurementById(@PathVariable Integer id){
        return measurementService.getMeasurementById(id);
    }

    @PutMapping("/{id}")
    public Result updateMeasurementById(@RequestBody Measurement measurement,@PathVariable Integer id){
        return measurementService.updateMeasurementById(measurement,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteMeasurementById(@PathVariable Integer id){
        return measurementService.deleteMeasurementById(id);
    }

}
