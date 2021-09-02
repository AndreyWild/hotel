package com.senla.service.impl;

import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.service.IMaintenanceService;
import com.senla.dao.impl.MaintenanceDao;
import com.senla.model.entities.Maintenance;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MaintenanceService implements IMaintenanceService {

    private IMaintenanceDao maintenanceDao;// = new MaintenanceDao();

//    @Autowired
//    public MaintenanceService(IMaintenanceDao maintenanceDao) {
//        this.maintenanceDao = maintenanceDao;
//    }

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
