package com.crudexample.service;

import com.crudexample.entity.Worker;

import java.util.List;

public interface WorkerService {

    Worker createWorker(Worker worker);
    List<Worker> getAllWorker();
    Worker getWorkerById(Long id);
    Worker updateWorker(Long id, Worker worker);
    void deleteWorker(Long id);
}
