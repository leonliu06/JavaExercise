package event;

import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;

//事件
class DoorEvent extends EventObject{
	
	private static final long serialVersionUID = 6496098798146410884L;
	
	private String doorState = "";
	
	public DoorEvent(Object source, String doorState){
		super(source);
		this.doorState = doorState;
	}
	
	public void setDoorState(String doorState){
		this.doorState = doorState;
	}
	
	public String getDoorState(){
		return this.doorState;
	}
}

//事件监听者（处理方法）
interface DoorListener extends EventListener{
	public void doorEvent(DoorEvent event);
}

class DoorListener1 implements DoorListener{
	@Override
	public void doorEvent(DoorEvent event){
		if(event.getDoorState() != null && event.getDoorState().equals("open")){
			System.out.println("door 1 opened");
		}else{
			System.out.println("door 2 closed");
		}
	}
}

class DoorListener2 implements DoorListener{
	@Override
	public void doorEvent(DoorEvent event){
		if(event.getDoorState() != null && event.getDoorState().equals("open")){
			System.out.println("door 2 opened");
		}else{
			System.out.println("door 2 closed");
		}
	}
}

//事件源
class DoorManager{
	
	private Collection listeners;
	
	//添加事件监听者（处理方法）
	public void addDoorListener(DoorListener listener){
		if(listeners == null){
			listeners = new HashSet();
		}
		listeners.add(listener);
	}
	//移除事件监听者（处理方法）
	public void removeDoorListener(DoorListener listener){
		if(listeners == null){
			return;
		}
		listeners.remove(listener);
	}	
	
	//触发开门事件
	protected void fireWorkspaceOpened(){
		if(listeners == null)
			return;
		DoorEvent event = new DoorEvent(this, "open");
		notifyListeners(event);
	}
	
	//触发关门事件
	protected void fireWorkspaceClosed(){
		if(listeners == null)
			return;
		DoorEvent event = new DoorEvent(this, "close");
		notifyListeners(event);
	}
	
	//通知所有的DoorListener
	private void notifyListeners(DoorEvent event){
		Iterator iterator = listeners.iterator();
		while(iterator.hasNext()){
			DoorListener listener = (DoorListener)iterator.next();
			listener.doorEvent(event);
		}
	}
	
}

public class JavaEventDemo {
	public static void main(String[] args){
		DoorManager manager =  new DoorManager();
		manager.addDoorListener(new DoorListener1());
		manager.addDoorListener(new DoorListener2());
		
		//开门
		manager.fireWorkspaceOpened();
		
		System.out.println("我已经进来了");
		
		//关门
		manager.fireWorkspaceClosed();
		
	}
}
