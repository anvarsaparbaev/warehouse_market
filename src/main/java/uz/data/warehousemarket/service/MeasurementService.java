package uz.data.warehousemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Measurement;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.MeasurementRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;


    public Result deleteMeasurementById(Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Measurement not found",false);
        }
        measurementRepository.deleteById(id);
        return new Result("Successfull deleted",false);
    }

    public Result updateMeasurementById(Measurement measurement,Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Measurement not found",false);
        }
        Measurement updatingMeasurement = byId.get();
        updatingMeasurement.setName(measurement.getName());
        updatingMeasurement.setActive(measurement.isActive());
        measurementRepository.save(updatingMeasurement);
        return new Result("Successfull updated",true);
    }

    public Measurement getMeasurementById(Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        return byId.orElse(null);
    }
    public List<Measurement> getAllMeasurements(){
        return measurementRepository.findAll();
    }
    public Result addMeasurement(Measurement measurement){
        boolean b = measurementRepository.existsByName(measurement.getName());
        if(b){
            return new Result("This measurement already exist",false);
        }
        measurementRepository.save(measurement);
        return new Result("Successfull saved",true);
    }



}
