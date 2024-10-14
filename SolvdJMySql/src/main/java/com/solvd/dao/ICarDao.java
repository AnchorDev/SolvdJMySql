package com.solvd.dao;

import com.solvd.model.Car;

import java.util.List;

public interface ICarDao extends IBaseDao<Car>{

    @Override
    Car getEntityById(int index);

    @Override
    List<Car> getEntities();

    @Override
    void insert(Car car);

    @Override
    void delete(int index);

    @Override
    void update(int index, Car car);
}
