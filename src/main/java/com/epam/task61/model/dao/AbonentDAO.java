package com.epam.task61.model.dao;

import com.epam.task61.controller.command.Command;
import com.epam.task61.model.entity.Book;
import com.epam.task61.util.InputUtility;
import com.epam.task61.util.ResourceManager;
import com.epam.task61.view.BookView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbonentDAO extends AbstractDAO {
    public static final String SHOW_ALL_BOOKS = "SELECT * FROM books";
    public static final String ADD_BOOK = "INSERT INTO books (title, author, publisher, year, pages, price)" +
            " VALUES (?, ?, ?, ?, ?, ?)";

    public AbonentDAO() {
        this.connector = new WrapperConnector();
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void addBook() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connector.dbCon.prepareStatement(ADD_BOOK);
preparedStatement.setString(1, InputUtility.inputString(view, manager));
preparedStatement.setString(2, InputUtility.inputString(view, manager));
preparedStatement.setString(3, InputUtility.inputString(view, manager));
preparedStatement.setInt(4, InputUtility.inputInt(view, manager));
preparedStatement.setInt(5, InputUtility.inputInt(view, manager));
preparedStatement.setDouble(6, InputUtility.inputInt(view, manager));
preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connector.closeConnection();
            preparedStatement.close();
        }
    }

    @Override
    public void deleteBook(Book book) {

    }

    @Override
    public Book[] showAllBooks() {
        Book[] books = null;
        List<Book> booksList = new ArrayList<>();
        Statement st = null;
        try {
            st = connector.stmt;
            ResultSet resultSet = st.executeQuery(SHOW_ALL_BOOKS);
            while (resultSet.next()) {
                Book book = new Book(resultSet.getString("title"), resultSet.getString("author"),
                        resultSet.getString("publisher"),
                        resultSet.getInt("year"),
                        resultSet.getInt("pages"),
                        resultSet.getDouble("pages"));
                booksList.add(book);
            }
            books = new Book[booksList.size()];
            int count = 0;
            for (Book book: booksList) {
                books[count] = book;
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

}
