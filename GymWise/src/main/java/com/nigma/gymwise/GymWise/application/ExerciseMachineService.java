package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.ExerciseMachine;
import com.nigma.gymwise.GymWise.domain.port.IExerciseMachineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseMachineService {

    private final IExerciseMachineRepository repository;
    private final UploadFile uploadFile;

    public ExerciseMachineService(IExerciseMachineRepository repository, UploadFile uploadFile) {
        this.repository = repository;
        this.uploadFile = uploadFile;
    }

    public ExerciseMachine save(ExerciseMachine exerciseMachine, MultipartFile multipartFile) throws IOException {

        final Integer id = exerciseMachine.getPkIdMch();
        final boolean isUpdate = (id != null && id > 0);

        if (isUpdate){

            if (multipartFile == null){
                exerciseMachine.setUrlImg(exerciseMachine.getUrlImg());
            }else{
                exerciseMachine.setUrlImg(uploadFile.upload(multipartFile));
            }

        }else{
            exerciseMachine.setUrlImg(uploadFile.upload(multipartFile));
        }

        return repository.save(exerciseMachine);
    }

    public Optional<ExerciseMachine> findById(Integer id) {
        return repository.findById(id);
    }

    public List<ExerciseMachine> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
