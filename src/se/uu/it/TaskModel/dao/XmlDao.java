package se.uu.it.TaskModel.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import se.uu.it.TaskModel.domain.Task;


public class XmlDao {

	/**
	 * @param args
	 */
	private static final String xmlFile = "Task.xml";
	private Document document;
	private Element root;
	public XmlDao() {
		File file = new File(xmlFile);

		try {
			// 判断文件的存在以增强程序的健壮性

			if (file.exists()) {
				// 文件存在,直接从文件读取文档对象
				SAXReader reader = new SAXReader();
				document = reader.read(file);
				root = document.getRootElement();
			} else {
				// 文件不存在,创建文档对象
				document = DocumentHelper.createDocument();
				root = document.addElement("tasks");// 创建根节点
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void save(Task task){
		Element TaskElm = root.addElement("task");
		
		Element TitleElm  = TaskElm.addElement("title");
		TitleElm.setText(task.getTitle());
		
		Element DateElm = TaskElm.addElement("date");
		DateElm.setText(task.getDate());
		
		Element TimeElm = TaskElm.addElement("time");
		TimeElm.setText(task.getTime());
		
		Element TimeTakenElm = TaskElm.addElement("duration");
		TimeTakenElm.setText(task.getDuration());
		
		Element CateElm = TaskElm.addElement("category");
		CateElm.setText(task.getCategory());
		
		Element PrioElm = TaskElm.addElement("priority");
		PrioElm.setText(task.getPriority());
		
		Element LocaElm = TaskElm.addElement("location");
		LocaElm.setText(task.getLocation());
		
		Element NoteElm = TaskElm.addElement("notes");
		NoteElm.addCDATA(task.getNotes());
		
		saveDocumentToFile();
	}
	
	public void delete(Task task){
		
		List<Element> nodes=root.elements("task");
		for(Iterator<Element> it=nodes.iterator();it.hasNext();){
			Element infoElm=(Element)it.next();
		if(infoElm.elementText("title").equals(task.getTitle())
				&& infoElm.elementText("date").equals(task.getDate())
				&& infoElm.elementText("time").equals(task.getTime())){
						root.remove(infoElm);
						saveDocumentToFile();
		}
	 }
	}
	
	public List<Task> fetchAllTaskFromXmlFile(){
		List<Task> retval=new ArrayList<Task>();
		List<Element> infoNodes=root.elements("task");
	
		for(Iterator<Element> it=infoNodes.iterator();it.hasNext();){
			Element elm=(Element)it.next();
			Task info=new Task();
			info.setTitle(elm.elementText("title"));
			info.setDate(elm.elementText("date"));
			info.setTime(elm.elementText("time"));
			info.setDuration(elm.elementText("duration"));
			info.setCategory(elm.elementText("category"));
			info.setPriority(elm.elementText("priority"));
			info.setNotes(elm.elementText("notes"));
			info.setLocation(elm.elementText("location"));
			
			
			retval.add(info);
		}
		
		return retval;
	}
	
	public List<Task> fetchOneDayTaskFromXmlFile(String date){
		List<Task> retval=new ArrayList<Task>();
		List<Element> infoNodes=root.elements("Task");
		
		for(Iterator<Element> it=infoNodes.iterator();it.hasNext();){
			Element elm=(Element)it.next();
			Task info=new Task();
			if(elm.elementText("date").equals(date)){
				info.setTitle(elm.elementText("title"));
				info.setDate(elm.elementText("date"));
				info.setTime(elm.elementText("time"));
				info.setDuration(elm.elementText("duration"));
				info.setCategory(elm.elementText("Category"));
				info.setPriority(elm.elementText("priority"));
				info.setNotes(elm.elementText("notes"));
				info.setLocation(elm.elementText("location"));
				
				
				retval.add(info);
			}
		}
		
		return retval;
	}
	
	
	private void saveDocumentToFile() {
	
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8"); 
			XMLWriter writer = new XMLWriter(new FileWriter(xmlFile),
					format);

			writer.write(document);
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

}
