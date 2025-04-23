import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSTimestamp;

public class EmployeeFormDb extends EOGenericRecord {

	public String empAddress() {
		return (String) storedValueForKey("empAddress");
	}

	public void setEmpAddress(String value) {
		takeStoredValueForKey(value, "empAddress");
	}

	public String removeCheck() {
		return (String) storedValueForKey("removeCheck");
	}

	public void setRemoveCheck(String value) {
		takeStoredValueForKey(value, "removeCheck");
	}

	public NSTimestamp empDob() {
		return (NSTimestamp) storedValueForKey("empDob");
	}

	public void setEmpDob(NSTimestamp value) {
		takeStoredValueForKey(value, "empDob");
	}

	public String empID() {
		return (String) storedValueForKey("empID");
	}

	public void setEmpID(String value) {
		takeStoredValueForKey(value, "empID");
	}

	public String empName() {
		return (String) storedValueForKey("empName");
	}

	public void setEmpName(String value) {
		takeStoredValueForKey(value, "empName");
	}

	public String empRole() {
		return (String) storedValueForKey("empRole");
	}

	public void setEmpRole(String value) {
		takeStoredValueForKey(value, "empRole");
	}

	public Integer empSal() {
		return (Integer) storedValueForKey("empSal");
	}

	public void setEmpSal(Integer value) {
		takeStoredValueForKey(value, "empSal");
	}

	public Integer deptFormID() {
		return (Integer) storedValueForKey("deptFormID");
	}

	public void setDeptFormID(Integer value) {
		takeStoredValueForKey(value, "deptFormID");
	}

//	public Integer selectedDept() {
//		return (Integer) storedValueForKey("selectedDept");
//	}
//
//	public void setSelectedDept(Integer value) {
//		takeStoredValueForKey(value, "selectedDept");
//	}

	public DeptForm deptForm() {
		return (DeptForm) storedValueForKey("deptForm");
	}

	public void setDeptForm(DeptForm value) {
		takeStoredValueForKey(value, "deptForm");
	}

}
