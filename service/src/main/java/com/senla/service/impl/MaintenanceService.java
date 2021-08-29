package com.senla.service.impl;

import com.senla.api.service.IMaintenanceService;
import com.senla.dao.impl.MaintenanceDao;
import com.senla.model.entities.Maintenance;

import java.util.List;

public class MaintenanceService implements IMaintenanceService {

    //@Autowired
    private final MaintenanceDao maintenanceDao = new MaintenanceDao();

    public Maintenance save(Maintenance entity) {
        return maintenanceDao.save(entity);
    }

    public Maintenance getById(Long id) {
        return maintenanceDao.getById(id);
    }

    public List<Maintenance> getAll() {
        return maintenanceDao.getAll();
    }

    public void delete(Maintenance entity) {
        maintenanceDao.delete(entity);
    }

    public void deleteById(Long id) {
        maintenanceDao.deleteById(id);
    }

    public void deleteAll() {
        maintenanceDao.deleteAll();
    }

    public void update(Maintenance entity) {
        maintenanceDao.update(entity);
    }

}
