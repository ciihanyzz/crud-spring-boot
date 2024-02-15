package com.crudexample.service;

import com.crudexample.entity.Worker;
import com.crudexample.repository.CustomerRepository;
import com.crudexample.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker createWorker(Worker worker) {
        Worker newWorker = workerRepository.save(worker);
        return newWorker;
    }

    @Override
    public List<Worker> getAllWorker() {
        List<Worker> allWorker = workerRepository.findAll();
        return allWorker;
    }

    @Override
    public Worker getWorkerById(Long id) {
        Worker getWorker = workerRepository.findById(id).orElse(null);
        return getWorker;
    }

    @Override
    public Worker updateWorker(Long id, Worker worker) {
        Optional<Worker> existingWorker = workerRepository.findById(id);
        if (existingWorker.isPresent()){
            Worker updatedWorker = existingWorker.get();
            updatedWorker.setFirstName(worker.getFirstName());
            updatedWorker.setLastName(worker.getLastName());
            updatedWorker.setEmail(worker.getEmail());
            updatedWorker.setPhoneNumber(worker.getPhoneNumber());
            updatedWorker.setSalary(worker.getSalary());
            workerRepository.save(updatedWorker);

            return updatedWorker;
        }
        return null;
    }

    @Override
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);

    }
}
