
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.appserver.WOComponent;

public class DeptDetails extends WOComponent {

	DeptForm ad;
	DeptForm d = new DeptForm();

	NSMutableArray<DeptForm> deptList = getAllDeptList();
	boolean c1 = false;
	NSArray<DeptForm> removedDetails = new NSMutableArray<DeptForm>();

	public DeptDetails(WOContext context) {
		super(context);

		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat("removeCheck = %@", new NSArray<>("true"));
		EOFetchSpecification eof = new EOFetchSpecification("DeptForm", qual, null);
		removedDetails = session().defaultEditingContext().objectsWithFetchSpecification(eof);
		if (removedDetails.count() > 0) {
			c1 = true;
		}
	}

	private NSMutableArray<DeptForm> getAllDeptList() {
		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat("removeCheck != %@ or removeCheck = null",
				new NSArray("true"));
		EOFetchSpecification eof = new EOFetchSpecification("DeptForm", qual, null);
		return (NSMutableArray<DeptForm>) session().defaultEditingContext().objectsWithFetchSpecification(eof);
	}

	public WOComponent editButton() {
		Main m = (Main) pageWithName("Main");
		m.dept = d;
		session().defaultEditingContext().deleteObject(d);
		return m;
	}

	public WOComponent removeButton() {
		d.setRemoveCheck("true");
		session().defaultEditingContext().saveChanges();
		DeptDetails de = (DeptDetails) pageWithName("DeptDetails");
		return de;
	}

	public WOComponent employeeButton() {
		return pageWithName("EmployeeForm");
	}

	public WOComponent addAgainButton() {
		ad.setRemoveCheck("false");
		session().defaultEditingContext().saveChanges();
		deptList.add(ad);
		return pageWithName("DeptDetails");
	}

	public WOComponent addButton() {
		return pageWithName("Main");

	}
}