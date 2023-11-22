package ru.nsu.fit.publify.publify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.publify.publify.dto.EmployeeDto;
import ru.nsu.fit.publify.publify.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> search(@RequestParam Long organizationId) {
        return employeeService.findEmployeesByOrganization(organizationId);
    }
}
