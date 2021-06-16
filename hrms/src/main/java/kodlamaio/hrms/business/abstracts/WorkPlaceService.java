package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.WorkPlace;

public interface WorkPlaceService {

	DataResult<List<WorkPlace>> getAll();
	
}
