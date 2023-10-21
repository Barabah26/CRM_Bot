package com.example.crm.view;

import com.example.crm.domain.Students;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route
@PermitAll
public class MainView extends VerticalLayout {

    private Grid<Students> grid = new Grid<>(Students.class);

    public MainView() {
        add(grid);
        grid.addColumn(Students::getFullName);
        grid.addColumn(Students::getYearEntry);
        grid.addColumn(Students::getStatement);
        grid.addColumn(Students::getPhoneNumber);
        grid.addColumn(Students::getGroup);





    }
}
