package com.senla.service.impl;

import com.senla.api.service.IMaintenanceService;
import com.senla.dao.impl.MaintenanceDao;
import com.senla.model.entities.Maintenance;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaintenanceService implements IMaintenanceService {


    private MaintenanceDao maintenanceDao;// = new MaintenanceDao();

    @Autowired
    public MaintenanceService(MaintenanceDao maintenanceDao) {
        this.maintenanceDao = maintenanceDao;
    }

    @Override
    @Transactional
    public Maintenance save(Maintenance entity) {
        return maintenanceDao.save(entity);
    }

    @Override
    @Transactional
    public Maintenance getById(Long id) {
        return maintenanceDao.getById(id);
    }

    @Override
    @Transactional
    public List<Maintenance> getAll() {
        return maintenanceDao.getAll();
    }

    @Override
    @Transactional
    public void delete(Maintenance entity) {
        maintenanceDao.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        maintenanceDao.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        maintenanceDao.deleteAll();
    }

    @Override
    @Transactional
    public void update(Maintenance entity) {
        maintenanceDao.update(entity);
    }

}
