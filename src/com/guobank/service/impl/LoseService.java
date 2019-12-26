package com.guobank.service.impl;

import com.guobank.dao.ILoseDao;
import com.guobank.dao.impl.LoseDao;
import com.guobank.service.ILoseService;

public class LoseService implements ILoseService {
    ILoseDao loseDao=new LoseDao();

    @Override
    public void Lose(String bankCardId) throws Exception {
        loseDao.Lose(bankCardId);
    }
}
