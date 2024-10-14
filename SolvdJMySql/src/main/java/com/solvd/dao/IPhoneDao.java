package com.solvd.dao;

import com.solvd.model.Phone;

import java.util.List;

public interface IPhoneDao extends IBaseDao<Phone> {

    @Override
    Phone getEntityById(int index);

    @Override
    List<Phone> getEntities();

    @Override
    void insert(Phone phone);

    @Override
    void delete(int index);

    @Override
    void update(int index, Phone phone);
}
