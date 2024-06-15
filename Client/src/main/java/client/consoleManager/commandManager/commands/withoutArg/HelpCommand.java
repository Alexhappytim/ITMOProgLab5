package client.consoleManager.commandManager.commands.withoutArg;

import client.Client;
import common.network.Request;


import java.util.Scanner;

public class HelpCommand implements Command {
    @Override
    public void execute(){

        Client.consoleManager.println("""
                help: вывести справку по доступным командам
                info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add (element): добавить новый элемент в коллекцию
                update {id} (element): обновить значение элемента коллекции, id которого равен заданному
                remove_by_id {id}: удалить элемент из коллекции по его id
                cleaг: Очистить коллекцию
                save: сохранить коллекцию в файл
                execute_script {file}: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь
                в интерактивном режиме.
                exit: завершить программу (без сохранения в файл)
                head: вывести первый элемент коллекции
                remove_head: вывести первый элемент коллекции и удалить его
                add_if_max (element): добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                filter_by_color {color}: вывести элементы, значение поля color которых равно заданному
                filter_contains_name {name}: Вывести элементы, значение поля пате которых содержит заданную подстроку
                filter_less_than_speaking {speaking}: вывести элементы, значение поля speaking которых меньше заданного
                register {login} {password}: добавляет нового пользователя на сервер, если логин уникален
                login {login} {password}: запоминает ваш логин и пароль для дальнейших запросов, но не проверяет их на корректность""");
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
