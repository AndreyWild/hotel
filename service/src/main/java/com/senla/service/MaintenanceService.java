package com.senla.service;

import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.service.IMaintenanceService;
import com.senla.model.entities.Maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MaintenanceService implements IMaintenanceService {

    @Autowired
    private IMaintenanceDao maintenanceDao;// = new MaintenanceDao();

    @Override
    public void save(Maintenance entity) {
        maintenanceDao.save(entity);
    }

    @Override
    public Maintenance getById(Long id) {
        return maintenanceDao.getById(id);
    }

    @Override
    public List<Maintenance> getAll() {
        return maintenanceDao.getAll();
    }

    @Override
    public List<Maintenance> findAll() {
        return maintenanceDao.findAll();
    }

    @Override
    public void delete(Maintenance entity) {
        maintenanceDao.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        maintenanceDao.deleteById(id);
    }

    @Override
    public void update(Maintenance entity) {
        maintenanceDao.update(entity);
    }
}
