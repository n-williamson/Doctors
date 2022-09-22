package com.doctors.repository;

import com.doctors.model.DoctorModel;
import com.doctors.repository.crudrepository.DoctorCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {

    @Autowired // inyeccion de dependencias, buscar en spring
    private DoctorCrudRepository doctorCrudRepository;

    public List<DoctorModel> getAllDoctors() {
        return (List<DoctorModel>) doctorCrudRepository.findAll();
    }

    public Optional<DoctorModel> getDoctor(Integer id) { // el optional quita el problema de la busqueda de id, puede ser null o un objeto de tipo drmodel
        return doctorCrudRepository.findById(id);
    }

    public DoctorModel saveDoctor(DoctorModel doctorModel) {
        return doctorCrudRepository.save(doctorModel);
    }

    public boolean deleteDoctor(Integer id) {
        doctorCrudRepository.deleteById(id);
        return true;
    }

    public DoctorModel updateDoctor(DoctorModel doctorModel) {
        return doctorCrudRepository.save(doctorModel);
    }


}
