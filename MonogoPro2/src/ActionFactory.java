import action.Action;
import action.DeleteService;
import action.DetailService;
import action.InputService;
import action.ListService;
import action.UpdateFormService;
import action.UpdateService;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action =null;
		System.out.println("action Factory");
		
		if(command.equals("list")) {
			action=new ListService();
		}else if(command.equals("input")){
			action=new InputService();
		}else if(command.equals("update_form")){
			action=new UpdateFormService();
		}else if(command.equals("update")){
			action=new UpdateService();
		}else if(command.equals("delete")){
			action=new DeleteService();
		}else if(command.equals("detail")){
			action=new DetailService();
		}
		return action;
	}
}
