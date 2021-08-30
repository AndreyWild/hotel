package com.senla.api.service;

import com.senla.api.dao.IMaintenanceDao;
import com.senla.model.entities.Maintenance;

public interface IMaintenanceService extends IGenericService<Maintenance>{

    void setMaintenanceDao(IMaintenanceDao maintenanceDao);
}
