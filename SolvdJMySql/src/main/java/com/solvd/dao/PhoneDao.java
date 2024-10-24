package com.solvd.dao;

import com.solvd.model.Phone;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PhoneDao implements IPhoneDao {

    private SqlSessionFactory sqlSessionFactory;

    public PhoneDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Phone getEntityById(int index) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.solvd.dao.IPhoneDao.getEntityById", index);
        }
    }

    @Override
    public List<Phone> getEntities() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.solvd.dao.IPhoneDao.getEntities");
        }
    }

    @Override
    public void insert(Phone phone) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.solvd.dao.IPhoneDao.insert", phone);
            session.commit();
        }
    }

    @Override
    public void delete(int index) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("com.solvd.dao.IPhoneDao.delete", index);
            session.commit();
        }
    }

    @Override
    public void update(int index, Phone phone) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            phone.setPhoneId(index);
            session.update("com.solvd.dao.IPhoneDao.update", phone);
            session.commit();
        }
    }
}
