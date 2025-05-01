package org.example.cvbuilderapp.services.interfaces;

import org.example.cvbuilderapp.dtos.objective.CreateObjectiveRequest;
import org.example.cvbuilderapp.dtos.objective.ObjectiveDto;
import org.example.cvbuilderapp.dtos.objective.UpdateObjectiveRequest;

public interface ObjectiveService extends BaseService<ObjectiveDto, CreateObjectiveRequest, UpdateObjectiveRequest, Long> {

}
