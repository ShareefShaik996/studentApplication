import com.webobjects.eocontrol.EOGenericRecord;

public class DeptForm extends EOGenericRecord {

	public String removeCheck() {
		return (String) storedValueForKey("removeCheck");
	}

	public void setRemoveCheck(String value) {
		takeStoredValueForKey(value, "removeCheck");
	}

	public Integer id() {
		return (Integer) storedValueForKey("id");
	}

	public void setId(Integer value) {
		takeStoredValueForKey(value, "id");
	}

	public String deptID() {
		return (String) storedValueForKey("deptID");
	}

	public void setDeptID(String value) {
		takeStoredValueForKey(value, "deptID");
	}

	public String deptLoc() {
		return (String) storedValueForKey("deptLoc");
	}

	public void setDeptLoc(String value) {

		takeStoredValueForKey(value, "deptLoc");
	}

	public String deptName() {
		return (String) storedValueForKey("deptName");
	}

	public void setDeptName(String value) {
		takeStoredValueForKey(value, "deptName");
	}

}
