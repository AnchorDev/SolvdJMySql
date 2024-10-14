package com.solvd;

import com.solvd.dao.jdbc.StudentDao;

public class OwnThread extends Thread{

    @Override
    public void run() {
        StudentDao studentDao = new StudentDao();
        studentDao.getEntities();
    }
}
