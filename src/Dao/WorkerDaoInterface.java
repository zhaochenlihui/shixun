package Dao;

import java.util.List;

import domain.Worker;

public interface WorkerDaoInterface {
	public void addWorker(Worker worker);
	public void deleteWorker(String[] workerNoList);
	public List<Worker> findAllWorkerList();
	public Worker findWorkerByNo(int workerNo);
	public void updateWorker(Worker user);
}
