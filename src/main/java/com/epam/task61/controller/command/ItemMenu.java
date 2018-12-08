package com.epam.task61.controller.command;

public enum ItemMenu {
    EXIT(new ExitCommand()),
    SHOW_BOOKS(new ShowBooksCommand()),

//    DELETE_BOOKS(new DeleteBooksCommand()),
    FIND_AUTHOR(new FindAuthorsCommand()),
    FIND_PUBLISH(new FindPublisherCommand()),
    FIND_YEAR(new FindYearCommand()),
    SORT_PUBLISH(new SortCommand()),
    LANG(new ChangeLanguareCommand()),
    ADD_BOOKS(new AddBooksCommand());

    private Command command;
    ItemMenu(Command command) {
        this.command = command;
    }
    public Command getCommand() {
        return command;
    }
}
