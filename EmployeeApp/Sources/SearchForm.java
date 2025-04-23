
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

import er.ajax.AjaxSubmitButton;

import com.webobjects.appserver.WOComponent;

public class SearchForm extends WOComponent {
	EmployeeFormDb empListItem = null;
	EmployeeFormDb empId = null;
	EmployeeFormDb empSID = null;
	String salValue = "";
	boolean andCheck, orCheck;
	String empSName = "";
	String empSRole = "";
	boolean c1 = false;
	boolean salCheck, salCheck1, salCheck2, salCheck3, empIdCheck, empNameCheck, empRoleCheck;
	String queries = "";
	EmployeeFormDb st;
	NSMutableArray<EmployeeFormDb> sortedEmp = null;
	NSArray<EmployeeFormDb> empList = new NSArray<EmployeeFormDb>();

	public SearchForm(WOContext context) {
		super(context);
		empList = getAllEmps();

	}

	private NSArray<EmployeeFormDb> getAllEmps() {
		EOFetchSpecification eof = new EOFetchSpecification("EmployeeFormDb", null, null);
		return session().defaultEditingContext().objectsWithFetchSpecification(eof);
	}

	public void goButton() {
		c1 = true;
		sortedEmp = new NSMutableArray<EmployeeFormDb>();
		if (orCheck) {
			if (empIdCheck) {
				for (int i = 0; i < empList.size(); i++) {
					if (empList.get(i).empID().equals(empSID.empID())) {
						sortedEmp.add(empList.get(i));
					}
				}
			}
			if (empNameCheck) {
				for (int i = 0; i < empList.size(); i++) {
					if (empList.get(i).empName().equals(empSName) || empList.get(i).empName() == empSName) {
						sortedEmp.add(empList.get(i));
					}
				}
			}
			if (empRoleCheck) {
				for (int i = 0; i < empList.size(); i++) {
					if (empList.get(i).empRole().equals(empSRole)) {
						sortedEmp.add(empList.get(i));
					}
				}
			}
			if (salCheck) {
				if (salCheck1) {
					for (int i = 0; i < empList.size(); i++) {
						if (empList.get(i).empSal() > Integer.parseInt(salValue)) {
							sortedEmp.add(empList.get(i));
						}
					}
				}
				if (salCheck2) {
					for (int i = 0; i < empList.size(); i++) {
						if (empList.get(i).empSal() < Integer.parseInt(salValue)) {
							sortedEmp.add(empList.get(i));
						}
					}
				}
				if (salCheck3) {
					for (int i = 0; i < empList.size(); i++) {
						if (empList.get(i).empSal() == Integer.parseInt(salValue)) {
							sortedEmp.add(empList.get(i));
						}
					}
				}
			}
		}
		if (andCheck) {
			NSMutableArray<EOQualifier> eoQula = new NSMutableArray<>();
			if (empIdCheck)
				eoQula.add(new EOKeyValueQualifier("empID", EOQualifier.QualifierOperatorLike, empSID.empID()));
			if (empNameCheck) {
				eoQula.add(new EOKeyValueQualifier("empName", EOQualifier.QualifierOperatorLike, empSName));
			}
			if (empRoleCheck) {
				eoQula.add(new EOKeyValueQualifier("empRole", EOQualifier.QualifierOperatorLike, empSRole));
			}
			if (salCheck) {
				if (salCheck1) {
					eoQula.add(new EOKeyValueQualifier("empSal", EOQualifier.QualifierOperatorGreaterThan,
							Integer.parseInt(salValue)));
				}
				if (salCheck2) {
					eoQula.add(new EOKeyValueQualifier("empSal", EOQualifier.QualifierOperatorLessThan,
							Integer.parseInt(salValue)));
				}
				if (salCheck3) {
					eoQula.add(new EOKeyValueQualifier("empSal", EOQualifier.QualifierOperatorEqual,
							Integer.parseInt(salValue)));
				}
			}
			EOAndQualifier andQualifier = new EOAndQualifier(eoQula);
			EOFetchSpecification fs = new EOFetchSpecification("EmployeeFormDb", andQualifier, null);
//			NSArray<EmployeeFormDb> equipments = ec.objectsWithFetchSpecification(fs);
			System.out.println(sortedEmp.size());
			sortedEmp = (NSMutableArray<EmployeeFormDb>) session().defaultEditingContext().objectsWithFetchSpecification(fs);
		}
//		return pageWithName("SearchForm");
	}

	public WOComponent backButton() {
		return pageWithName("EmployeeDetails");
	}
}