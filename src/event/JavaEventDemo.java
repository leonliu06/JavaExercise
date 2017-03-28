package event;

import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;

//�¼�
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

//�¼������ߣ���������
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

//�¼�Դ
class DoorManager{
	
	private Collection listeners;
	
	//����¼������ߣ���������
	public void addDoorListener(DoorListener listener){
		if(listeners == null){
			listeners = new HashSet();
		}
		listeners.add(listener);
	}
	//�Ƴ��¼������ߣ���������
	public void removeDoorListener(DoorListener listener){
		if(listeners == null){
			return;
		}
		listeners.remove(listener);
	}	
	
	//���������¼�
	protected void fireWorkspaceOpened(){
		if(listeners == null)
			return;
		DoorEvent event = new DoorEvent(this, "open");
		notifyListeners(event);
	}
	
	//���������¼�
	protected void fireWorkspaceClosed(){
		if(listeners == null)
			return;
		DoorEvent event = new DoorEvent(this, "close");
		notifyListeners(event);
	}
	
	//֪ͨ���е�DoorListener
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
		
		//����
		manager.fireWorkspaceOpened();
		
		System.out.println("���Ѿ�������");
		
		//����
		manager.fireWorkspaceClosed();
		
	}
}
