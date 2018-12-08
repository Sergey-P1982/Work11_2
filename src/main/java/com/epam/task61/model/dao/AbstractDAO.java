package com.epam.task61.model.dao;

import com.epam.task61.model.entity.Book;
import com.epam.task61.util.ResourceManager;
import com.epam.task61.view.BookView;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO {
    protected BookView view = new BookView();
    protected ResourceManager manager = ResourceManager.INSTANCE;
    public WrapperConnector connector;
    public abstract void updateBook(Book book);
    public abstract void addBook() throws SQLException;
    public abstract void deleteBook(Book book);
    public abstract Book[] showAllBooks();

    public void close() throws SQLException {
        connector.closeConnection();
    }
    protected void closeStatement(Statement statement) throws SQLException {
        connector.closeStatement(statement);
    }
}
