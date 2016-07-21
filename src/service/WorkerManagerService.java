package service;

import java.sql.Connection;
import java.util.List;

import Dao.WorkerDao;
import domain.Worker;
import utils.DBUtils;
import utils.ServiceException;

public class WorkerManagerService {

	private static WorkerManagerService instance=new WorkerManagerService();
	
	public static WorkerManagerService getInstance(){
		return instance;
	}
	
	public WorkerManagerService(){
	}
	public void addWorker(Worker worker) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			WorkerDao workerDao = new WorkerDao(conn);
			DBUtils.beginTransaction(conn);
			workerDao.addWorker(worker);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			e.printStackTrace();
//			throw new ServiceException("添加用户错误");
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	/**
	 * 用户查询
	 * @param userId    用户ID
	 * @return userList 用户信息实体
	 */
	public Worker findWorkerById(int workerNo) {
		Worker worker = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			WorkerDao workerDao = new WorkerDao(conn);
			DBUtils.beginTransaction(conn);
			worker = workerDao.findWorkerByNo(workerNo);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("查询用户错误", e);
			//e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return worker;
	}

	/**
	 * 查询所有用户
	 * @return userList 用户信息实体集合
	 */
	public List<Worker> findAllWorkerList() {
		List<Worker> workerList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
			WorkerDao workerDao = new WorkerDao(conn);
			DBUtils.beginTransaction(conn);
			workerList = workerDao.findAllWorkerList();
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("用户列表错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return workerList;
	}

	/**
	 * 删除用户
	 * @param userIdList 用户ID集合
	 */
	public void deleteWorker(String[] workerIdList) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			WorkerDao workerDao = new WorkerDao(conn);
			DBUtils.beginTransaction(conn);
			workerDao.deleteWorker(workerIdList);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("删除用户错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	/**
	 * 修改用户信息
	 * @param worker 用户信息实体
	 */
	public void modifyWorker(Worker worker) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			WorkerDao workerDao = new WorkerDao(conn);
			DBUtils.beginTransaction(conn);
			workerDao.updateWorker(worker);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("修改用户错误", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}
	public List<Worker> findWorker(Worker u)
	{
		List<Worker> workerList = null;
		Connection conn = null;
		try {
		conn = DBUtils.getConnection();
		System.out.println(conn);	
			WorkerDao workerDao = new WorkerDao(conn);
			DBUtils.beginTransaction(conn);
			workerList = workerDao.findWorker(u);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			//throw new ServiceException("用户列表错误", e);
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return workerList;
	}
	
}

