package com.senla.dao;

import com.senla.api.dao.IMaintenanceDao;
import com.senla.model.entities.Maintenance;
import org.springframework.stereotype.Repository;

@Repository
public class MaintenanceDao extends AbstractDao<Maintenance> implements IMaintenanceDao {

    @Override
    protected Class<Maintenance> getGenericClass() {
        return Maintenance.class;
    }
}
