
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.appserver.WOComponent;

public class EmployeeDetails extends WOComponent {

	EmployeeFormDb empDb = null;
	public NSMutableArray<EmployeeFormDb> empList = null;
	NSArray<EmployeeFormDb> removedEmpList = new NSMutableArray<EmployeeFormDb>();
	EmployeeFormDb empListItem = null;
	EmployeeFormDb empRem;
	boolean c1 = false;
	// empListItem.selectedDept
	String empDeptName;

	DeptForm deptForm;

	public EmployeeDetails(WOContext context) {
		super(context);
		empDb = new EmployeeFormDb();
		empList = getAllEmployees();
		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat("removeCheck =%@", new NSArray<>("true"));
		EOFetchSpecification eof = new EOFetchSpecification("EmployeeFormDb", qual, null);
		removedEmpList = session().defaultEditingContext().objectsWithFetchSpecification(eof);
		if (removedEmpList.count() > 0) {
			c1 = true;
		}
	}

	private NSMutableArray<EmployeeFormDb> getAllEmployees() {
		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat("removeCheck !=%@", new NSArray<>("true"));
		EOFetchSpecification eof = new EOFetchSpecification("EmployeeFormDb", qual, null);
//		empDeptName=session().defaultEditingContext().objectsWithFetchSpecification(""qual, arg1)
		eof.setRefreshesRefetchedObjects(true);
		return (NSMutableArray<EmployeeFormDb>) session().defaultEditingContext().objectsWithFetchSpecification(eof);
	}

	public WOComponent deptButton() {
		return pageWithName("DeptDetails");
	}

//	public NSMutableArray<EmployeeFormDb> getAllEmployees() {
//		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat("removeCheck !=%@", new NSArray<>("true"));
//		EOFetchSpecification eof = new EOFetchSpecification("EmployeeFormDb", qual, null);
////		empDeptName=session().defaultEditingContext().objectsWithFetchSpecification(""qual, arg1)
//		eof.setRefreshesRefetchedObjects(true);
//		return (NSMutableArray<EmployeeFormDb>) session().defaultEditingContext().objectsWithFetchSpecification(eof);
//	}

	public WOComponent editButton() {
		EmployeeForm m = (EmployeeForm) pageWithName("EmployeeForm");
		m.emp = empListItem;
		m.temp = true;
//		session().defaultEditingContext().deleteObject(empListItem);
		return m;
//		return pageWithName("EmployeeDetails");
	}

	public WOComponent removeButton() {
		empListItem.setRemoveCheck("true");
		session().defaultEditingContext().saveChanges();
		EmployeeDetails de = (EmployeeDetails) pageWithName("EmployeeDetails");
		return de;
	}

	public WOComponent addAgainButton() {
		empRem.setRemoveCheck("false");
		session().defaultEditingContext().saveChanges();
		empList.add(empRem);
		return pageWithName("EmployeeDetails");
	}

	public WOComponent addButton() {
		return pageWithName("EmployeeForm");
	}

	public WOComponent searchButton() {
		return pageWithName("SearchForm");
	}

}