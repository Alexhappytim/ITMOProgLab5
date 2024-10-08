package ConsoleManager.commands.withoutArg;

import ConsoleManager.commands.withoutArg.Command;
import execution.ExecutionManager;

import java.util.Scanner;

public class HelpCommand implements Command {
    @Override
    public void execute(){
        ExecutionManager.consoleManager.println("""
                Плейсхолдер в виде пасты с задания
                help: вывести справку по доступным командам
                Info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add (element): добавить новый элемент в коллекцию
                update id (element): обновить значение элемента коллекции, id которого равен заданному
                remove by id id: удалить элемент из коллекции по его id
                cleaг: Очистить коллекцию
                save: сохранить коллекцию в файл
                execute script file паже: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь
                в интерактивном режиме.
                exit: завершить программу (без сохранения в файл)
                head: вывести первый элемент коллекции
                remove head: вывести первый элемент коллекции и удалить его
                add if max (element): добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                filter by color color: вывести элементы, значение поля согог которых равно заданному
                filter_contains_name name: Вывести элементы, значение поля пате которых содержит заданную подстроку
                filter less than speaking speaking: вывести элементы, значение поля speaking которых меньше заданного""");
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
