package com.epam.task61.controller;

import com.epam.task61.controller.command.Command;
import com.epam.task61.controller.command.ItemMenu;
import com.epam.task61.model.dao.AbonentDAO;
import com.epam.task61.model.dao.AbstractDAO;
import com.epam.task61.util.InputUtility;
import com.epam.task61.util.ResourceManager;
import com.epam.task61.view.BookView;
import com.epam.task61.exception.UnExistItemMenu;

import java.sql.SQLException;

public class Controller {
    ResourceManager manager = ResourceManager.INSTANCE;
    private BookView view = new BookView();


    public void run() {
        while (true) {
            try {
                view.printMessage(manager.getMessage("mainMenu"));
                int number = InputUtility.inputInt(view, manager);
                Command command = defineCommand(number);
                view.printMessage(command.execute());
            } catch (UnExistItemMenu exp) {
                view.printError(exp.getMessage());
            }
        }
    }

    private Command defineCommand(int number) throws UnExistItemMenu {
        ItemMenu[] itemMenus = ItemMenu.values();
        if (number < 0 || number >= itemMenus.length) {
            throw new UnExistItemMenu(manager.getMessage("WRONG_INPUT_DATA"));
        } else if (number > 0 || number <= itemMenus.length) {
            AbstractDAO connection = new AbonentDAO();
            if (!connection.connector.getConnectStatus()) {
                view.printMessage("The connection to the database is not available. Try to connect later");
                number = 0;
            }
        }
        return itemMenus[number].getCommand();
    }
}
