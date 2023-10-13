package com.example.crm.views;

import com.example.crm.data.entity.Person;
import com.example.crm.data.service.PersonRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@PermitAll
@Route(value = "")
public class TableView extends VerticalLayout {

    private final PersonRepository repo;

    public TableView(PersonRepository repo) {
        this.repo = repo;
        add(new H1("Vaadin Grid examples"));

        var tabSheet = new TabSheet();
        tabSheet.setWidth("100%");
        tabSheet.add("Grid backed with a list", listGrid());
        tabSheet.add("Paged grid", pagedGrid());

        add(tabSheet);
    }

    private Component listGrid() {
        var grid = new Grid<>(Person.class);
        grid.setColumns("firstName", "lastName", "email");
        grid.setItems(repo.findAll());
        return grid;
    }

    private Component pagedGrid() {
        var grid = new Grid<>(Person.class);
        grid.setColumns("firstName", "lastName", "email");
        grid.setItems(VaadinSpringDataHelpers.fromPagingRepository(repo));
        return grid;
    }


}
