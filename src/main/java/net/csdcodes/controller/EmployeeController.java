package net.csdcodes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.csdcodes.model.Request;
import net.csdcodes.services.RequestService;

/**
 * @author jmatos
 * @since 2022-4-09
 */

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private RequestService service;

    @PostMapping("/insert")
    private Request insert(@RequestBody Request request) {
        return service.insert(request);
    }

    @GetMapping("/requests")
    private List<Request> employees() {
        return service.findAll();
    }

    @DeleteMapping("/delete")
    private void delete(@RequestParam("id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/get")
    private Request get(@RequestParam("id") int id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    private Request update(@ModelAttribute("request") Request request) {
        return service.update(request);
    }

}
