package com.senla.dao.impl;

import com.senla.api.dao.IMaintenanceDao;
import com.senla.model.entities.Maintenance;
import org.springframework.stereotype.Repository;

@Repository
public class MaintenanceDao extends AbstractDao<Maintenance> implements IMaintenanceDao {
}
