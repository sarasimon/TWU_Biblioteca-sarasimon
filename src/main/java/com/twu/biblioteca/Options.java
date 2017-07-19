package com.twu.biblioteca;

public class Options {

    public static final String BOOKDISPLAYFORMAT = "%-15s %-15s %-10s\n";

    private Biblioteca biblioteca = new Biblioteca();

    public Options(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public Options(){
        this.biblioteca = new Biblioteca();
    }

    public String ask() {
        return "Option 1. Show List Of Books (Press 1)\nOption 2. Check out a book (Insert title of the book)\nOption 3. Quit de program (press \"q\")";
    }

    public Boolean returnOptions(String opt) {
        if (opt.equals("1")) {
            optionListOfBooks();
        } else if (opt.equals("q")) {
            return false;
        } else if(biblioteca.titleExists(opt)){
            checkOutBook(opt);
        } else {
            invalidOption();
        }
        return true;
    }

    private void checkOutBook(String opt) {
        biblioteca.checkOut(opt);
        System.out.println("Thank you! Enjoy the book");
    }

    void optionListOfBooks() {
        String outputInColumns = String.format(BOOKDISPLAYFORMAT, "Title", "Author", "Year Published");
        for (Book iBook: biblioteca.getListOfBooks()) {
            outputInColumns += String.format(BOOKDISPLAYFORMAT, iBook.getTitle(), iBook.getAuthor(), iBook.getYearPublished());
        }
        System.out.println(outputInColumns);
    }

    void invalidOption(){
        System.out.println("Select a valid option!");
    }


}
