// $LastChangedRevision$ DO NOT EDIT.  Make changes to EmployeeFormDb.java instead.
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EmployeeFormDb extends  EOGenericRecord {
	public static final String ENTITY_NAME = "EmployeeFormDb";

	// Attributes
	public static final String EMP_ADDRESS_KEY = "empAddress";
	public static final String EMP_DOB_KEY = "empDob";
	public static final String EMP_ID_KEY = "empID";
	public static final String EMP_NAME_KEY = "empName";
	public static final String EMP_ROLE_KEY = "empRole";
	public static final String EMP_SAL_KEY = "empSal";
	public static final String REMOVE_CHECK_KEY = "removeCheck";

	// Relationships
	public static final String DEPT_FORM_KEY = "deptForm";

  private static Logger LOG = Logger.getLogger(_EmployeeFormDb.class);

  public EmployeeFormDb localInstanceIn(EOEditingContext editingContext) {
    EmployeeFormDb localInstance = (EmployeeFormDb)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String empAddress() {
    return (String) storedValueForKey("empAddress");
  }

  public void setEmpAddress(String value) {
    if (_EmployeeFormDb.LOG.isDebugEnabled()) {
    	_EmployeeFormDb.LOG.debug( "updating empAddress from " + empAddress() + " to " + value);
    }
    takeStoredValueForKey(value, "empAddress");
  }

  public NSTimestamp empDob() {
    return (NSTimestamp) storedValueForKey("empDob");
  }

  public void setEmpDob(NSTimestamp value) {
    if (_EmployeeFormDb.LOG.isDebugEnabled()) {
    	_EmployeeFormDb.LOG.debug( "updating empDob from " + empDob() + " to " + value);
    }
    takeStoredValueForKey(value, "empDob");
  }

  public String empID() {
    return (String) storedValueForKey("empID");
  }

  public void setEmpID(String value) {
    if (_EmployeeFormDb.LOG.isDebugEnabled()) {
    	_EmployeeFormDb.LOG.debug( "updating empID from " + empID() + " to " + value);
    }
    takeStoredValueForKey(value, "empID");
  }

  public String empName() {
    return (String) storedValueForKey("empName");
  }

  public void setEmpName(String value) {
    if (_EmployeeFormDb.LOG.isDebugEnabled()) {
    	_EmployeeFormDb.LOG.debug( "updating empName from " + empName() + " to " + value);
    }
    takeStoredValueForKey(value, "empName");
  }

  public String empRole() {
    return (String) storedValueForKey("empRole");
  }

  public void setEmpRole(String value) {
    if (_EmployeeFormDb.LOG.isDebugEnabled()) {
    	_EmployeeFormDb.LOG.debug( "updating empRole from " + empRole() + " to " + value);
    }
    takeStoredValueForKey(value, "empRole");
  }

  public Integer empSal() {
    return (Integer) storedValueForKey("empSal");
  }

  public void setEmpSal(Integer value) {
    if (_EmployeeFormDb.LOG.isDebugEnabled()) {
    	_EmployeeFormDb.LOG.debug( "updating empSal from " + empSal() + " to " + value);
    }
    takeStoredValueForKey(value, "empSal");
  }

  public String removeCheck() {
    return (String) storedValueForKey("removeCheck");
  }

  public void setRemoveCheck(String value) {
    if (_EmployeeFormDb.LOG.isDebugEnabled()) {
    	_EmployeeFormDb.LOG.debug( "updating removeCheck from " + removeCheck() + " to " + value);
    }
    takeStoredValueForKey(value, "removeCheck");
  }

  public DeptForm deptForm() {
    return (DeptForm)storedValueForKey("deptForm");
  }

  public void setDeptFormRelationship(DeptForm value) {
    if (_EmployeeFormDb.LOG.isDebugEnabled()) {
      _EmployeeFormDb.LOG.debug("updating deptForm from " + deptForm() + " to " + value);
    }
    if (value == null) {
    	DeptForm oldValue = deptForm();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "deptForm");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "deptForm");
    }
  }
  

  public static EmployeeFormDb createEmployeeFormDb(EOEditingContext editingContext, String empAddress
, NSTimestamp empDob
, String empID
, String empName
, String empRole
, Integer empSal
) {
    EmployeeFormDb eo = (EmployeeFormDb) EOUtilities.createAndInsertInstance(editingContext, _EmployeeFormDb.ENTITY_NAME);    
		eo.setEmpAddress(empAddress);
		eo.setEmpDob(empDob);
		eo.setEmpID(empID);
		eo.setEmpName(empName);
		eo.setEmpRole(empRole);
		eo.setEmpSal(empSal);
    return eo;
  }

  public static NSArray<EmployeeFormDb> fetchAllEmployeeFormDbs(EOEditingContext editingContext) {
    return _EmployeeFormDb.fetchAllEmployeeFormDbs(editingContext, null);
  }

  public static NSArray<EmployeeFormDb> fetchAllEmployeeFormDbs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EmployeeFormDb.fetchEmployeeFormDbs(editingContext, null, sortOrderings);
  }

  public static NSArray<EmployeeFormDb> fetchEmployeeFormDbs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EmployeeFormDb.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EmployeeFormDb> eoObjects = (NSArray<EmployeeFormDb>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static EmployeeFormDb fetchEmployeeFormDb(EOEditingContext editingContext, String keyName, Object value) {
    return _EmployeeFormDb.fetchEmployeeFormDb(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EmployeeFormDb fetchEmployeeFormDb(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EmployeeFormDb> eoObjects = _EmployeeFormDb.fetchEmployeeFormDbs(editingContext, qualifier, null);
    EmployeeFormDb eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EmployeeFormDb)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EmployeeFormDb that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EmployeeFormDb fetchRequiredEmployeeFormDb(EOEditingContext editingContext, String keyName, Object value) {
    return _EmployeeFormDb.fetchRequiredEmployeeFormDb(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EmployeeFormDb fetchRequiredEmployeeFormDb(EOEditingContext editingContext, EOQualifier qualifier) {
    EmployeeFormDb eoObject = _EmployeeFormDb.fetchEmployeeFormDb(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EmployeeFormDb that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EmployeeFormDb localInstanceIn(EOEditingContext editingContext, EmployeeFormDb eo) {
    EmployeeFormDb localInstance = (eo == null) ? null : (EmployeeFormDb)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
