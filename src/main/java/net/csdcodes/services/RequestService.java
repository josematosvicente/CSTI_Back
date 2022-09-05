package net.csdcodes.services;

import java.util.List;

import net.csdcodes.model.Request;

public interface RequestService {
    Request insert(Request e);

    List<Request> findAll();

    Request findById(int id);

    int deleteById(int id);

    Request update(Request request);
}
