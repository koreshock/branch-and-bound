/*
 * @author gautham
 */
package system;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import shared.Shared;
import api.Task;

/**
 * The remote interface that the ComputeServers use to communicate with the ComputeSpace.
 */
public interface Computer2Space extends Remote{
		
	/**
	 * Registers the Computer and creates a ComputerProxy which runs as a separate thread to process the submitted Tasks and to return the Results back to the ComputeSpace.
	 *
	 * @param computer the Computer to be registered
	 * @return space
	 * @throws RemoteException the remote exception
	 */
	void register(Computer computer) throws RemoteException;	
	
	/**
	 * Stores the newly created sub-tasks and the successor task in the appropriate data structures in Space.
	 *
	 * @param <T> the generic type
	 * @param parentTask the parent task
	 * @param childTasks the child tasks
	 * @param successorTask the successor task
	 * @throws RemoteException the remote exception
	 */
	<T> void storeTasks(Task<T> parentTask, List<Task<T>> childTasks, Task<T> successorTask) throws RemoteException;	
	
	
	
	/**
	 * Stores the result of the currently executed task (may be a sub-task or a successor task) in Space.
	 *
	 * @param <T> the generic type
	 * @param task the successor task
	 * @throws RemoteException the remote exception
	 */
	<T> void storeResult(Task<T> task) throws RemoteException;    
	
	
	/**
	 * Sets the shared object in Space.
	 * The Computer propagates the proposed newer shared object to the Space by calling the Space’s setShared method (using a Space Proxy).
	 *
	 * @param shared the new shared object
	 * @param computerId the computer id
	 * @throws RemoteException the remote exception
	 */
	void setShared(Shared<?> shared, int computerId) throws RemoteException;
	
	
}