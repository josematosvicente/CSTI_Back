package net.csdcodes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.csdcodes.model.Request;
import net.csdcodes.repository.RequestDao;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestDao requestDao;

    @Override
    public Request insert(Request request) {
        Request e = new Request();
        e.setId(requestDao.insert(request));
        return e;
    }

    @Override
    public List<Request> findAll() {
        return requestDao.findAll();
    }

    @Override
    public Request findById(int id) {
        return requestDao.findById(id);
    }

    @Override
    public int deleteById(int id) {
        return requestDao.deleteById(id);
    }

    @Override
    public Request update(Request request) {
        Request e = new Request();
        e.setId(requestDao.update(request));
        return e;

    }

}
