package com.senla.service.impl;

import com.senla.api.service.IMaintenanceService;
import com.senla.dao.impl.MaintenanceDao;
import com.senla.model.entities.Maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("maintenanceService")
public class MaintenanceService implements IMaintenanceService {

    @Autowired
    private MaintenanceDao maintenanceDao;// = new MaintenanceDao();

    @Autowired
    @Transactional
    public Maintenance save(Maintenance entity) {
        return maintenanceDao.save(entity);
    }

    @Autowired
    @Transactional
    public Maintenance getById(Long id) {
        return maintenanceDao.getById(id);
    }

    @Autowired
    @Transactional
    public List<Maintenance> getAll() {
        return maintenanceDao.getAll();
    }

    @Autowired
    @Transactional
    public void delete(Maintenance entity) {
        maintenanceDao.delete(entity);
    }

    @Autowired
    @Transactional
    public void deleteById(Long id) {
        maintenanceDao.deleteById(id);
    }

    @Autowired
    @Transactional
    public void deleteAll() {
        maintenanceDao.deleteAll();
    }

    @Autowired
    @Transactional
    public void update(Maintenance entity) {
        maintenanceDao.update(entity);
    }

}
