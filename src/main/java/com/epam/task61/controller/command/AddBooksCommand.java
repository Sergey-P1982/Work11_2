package com.epam.task61.controller.command;

import com.epam.task61.model.dao.AbonentDAO;
import com.epam.task61.model.dao.AbstractDAO;

import java.sql.SQLException;

public class AddBooksCommand extends Command {
    @Override
    public String execute() {
        view.printMessage("Add a book: [title, author, publisher, year, pages, price   ]");
        AbstractDAO dao = new AbonentDAO();
        try {
            dao.addBook();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        serviceBooks.saveBooks();
                return null;
    }

}