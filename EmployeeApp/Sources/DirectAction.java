
// Generated by the WOLips Templateengine Plug-in at 22-Nov-2023 3:23:11 PM

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WODirectAction;

public class DirectAction extends WODirectAction {

	public DirectAction(WORequest request) {
		super(request);
	}

	public WOActionResults defaultAction() {
		return pageWithName(Main.class.getName());
	}
}
