package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import java.util.List;

public interface FieldService<T> {

	Result verifyData(T data);
	
	DataResult<List<T>> getAll();
	
}
