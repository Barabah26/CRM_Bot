package com.example.crm.view;

import com.example.crm.domain.Students;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.userdetails.UserDetails;

@Route
@PermitAll
public class MainView extends AppLayout {

    private final transient AuthenticationContext authContext;

    private Grid<Students> grid = new Grid<>(Students.class);
    public MainView(AuthenticationContext authContext) {
        this.authContext = authContext;

        H1 logo = new H1("ДЕКАНАТ ЛДУ БЖД");
        logo.addClassName("logo");
        HorizontalLayout
                header =
                authContext.getAuthenticatedUser(UserDetails.class)
                        .map(user -> {
                            Button logout = new Button("Logout", click ->
                                    this.authContext.logout());
                            Span loggedUser = new Span("Welcome " + user.getUsername());
                            return new HorizontalLayout(logo, loggedUser, logout);
                        }).orElseGet(() -> new HorizontalLayout(logo));
        header.setSizeFull();
        addToNavbar(header);
        configureGrid();

    }

    private void configureGrid() {
        addToDrawer(grid);
        grid.setColumns();
        grid.addColumn(students -> students.getTelegramId()).setHeader("Телеграм ID").setAutoWidth(true);
        grid.addColumn(students -> students.getFullName()).setHeader("Повне ім'я").setAutoWidth(true);
        grid.addColumn(students -> students.getGroup()).setHeader("Група").setAutoWidth(true);
        grid.addColumn(students -> students.getYearEntry()).setHeader("Рік вступу").setAutoWidth(true);
        grid.addColumn(students -> students.getStatement()).setHeader("Тип довідки").setAutoWidth(true);
        grid.addColumn(students -> students.getPhoneNumber()).setHeader("Номер телефону").setAutoWidth(true);
        grid.addColumn(student -> {
            Checkbox checkbox = new Checkbox();
            // Додайте обробник подій, який буде виконуватися при зміні стану чекбоксу
            checkbox.addValueChangeListener(event -> {
                boolean isChecked = event.getValue();
                // Ваш код для обробки зміни стану чекбоксу, наприклад, оновлення даних або їх збереження
            });
            return checkbox;
        }).setHeader("Довідка готова").setAutoWidth(true);

//        grid.setSizeFull();
        setContent(grid);
    }

}
