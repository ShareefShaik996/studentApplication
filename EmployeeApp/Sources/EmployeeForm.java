
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

import er.ajax.AjaxUpdateContainer;

import com.webobjects.appserver.WOComponent;

public class EmployeeForm extends WOComponent {

	EmployeeFormDb emp = null;
	NSArray<DeptForm> empDeptList = null;
	DeptForm deptItem = null;
	DeptForm deptName;
	DeptForm selectedDep;
	boolean temp,c1=false;
	NSArray<EmployeeFormDb> allEmpList=new NSMutableArray<EmployeeFormDb>();
	
	public EmployeeForm(WOContext context) {
		super(context);
		emp = new EmployeeFormDb();
		allEmpList=getAllEmpPresent();
		empDeptList = getValuesOfDeptNames();
	}

	private NSArray<EmployeeFormDb> getAllEmpPresent() {
		// TODO Auto-generated method stub
		EOFetchSpecification eof=new EOFetchSpecification("EmployeeFormDb",null,null);
		return session().defaultEditingContext().objectsWithFetchSpecification(eof);
	}

	public WOComponent saveButton() {
//		emp.setEmpSal(emp.empSal());
		for(int i=0;i<allEmpList.size();i++) {
			if(allEmpList.get(i).empID().equals(emp.empID())) {
				EmployeeForm ec=(EmployeeForm) pageWithName("EmployeeForm");
				ec.c1=true;
				return ec;
			}
		}
		emp.setDeptForm(selectedDep);
		emp.setRemoveCheck("false");
		if (temp) {
			session().defaultEditingContext().saveChanges();
			temp=false;
		} else {
			session().defaultEditingContext().insertObject(emp);
			session().defaultEditingContext().saveChanges();
		}
		emp = new EmployeeFormDb();
		return pageWithName("EmployeeDetails");

	}


	public WOComponent backButton() {
		return pageWithName("DeptDetails");
	}

	private NSArray<DeptForm> getValuesOfDeptNames() {
		EOFetchSpecification eof = new EOFetchSpecification("DeptForm", null, null);
		return session().defaultEditingContext().objectsWithFetchSpecification(eof);
	}
}