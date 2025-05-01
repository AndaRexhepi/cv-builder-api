package org.example.cvbuilderapp.services.interfaces;

import org.example.cvbuilderapp.dtos.pursuit.CreatePursuitRequest;
import org.example.cvbuilderapp.dtos.pursuit.PursuitDto;
import org.example.cvbuilderapp.dtos.pursuit.UpdatePursuitRequest;

public interface PursuitService extends BaseService<PursuitDto, CreatePursuitRequest, UpdatePursuitRequest, Long> {
}
