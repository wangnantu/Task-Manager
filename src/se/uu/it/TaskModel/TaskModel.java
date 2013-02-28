package se.uu.it.TaskModel;

import java.util.List;



import se.uu.it.TaskModel.dao.XmlDao;
import se.uu.it.TaskModel.domain.Task;

public class TaskModel {
	
	private XmlDao xmlPersistence;
	private List<Task> list;
	
	public TaskModel(){
		xmlPersistence=new XmlDao();
		list=xmlPersistence.fetchAllTaskFromXmlFile();

	}
	
	public void SaveTask(Task task){
		xmlPersistence.save(task);

	}
	
	public void DeleteTask(Task task){
		xmlPersistence.delete(task);
	}
	

	
	public List<Task> getList() {
		return list;
	}
	
	
}
