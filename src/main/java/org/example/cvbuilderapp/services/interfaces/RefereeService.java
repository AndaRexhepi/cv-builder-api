package org.example.cvbuilderapp.services.interfaces;

import org.example.cvbuilderapp.dtos.referee.CreateRefereeRequest;
import org.example.cvbuilderapp.dtos.referee.RefereeDto;
import org.example.cvbuilderapp.dtos.referee.UpdateRefereeRequest;
import org.example.cvbuilderapp.entities.Referee;

public interface RefereeService extends BaseService<RefereeDto, CreateRefereeRequest, UpdateRefereeRequest, Long>{
}
