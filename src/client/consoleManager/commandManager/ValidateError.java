package client.consoleManager.commandManager;


public enum ValidateError implements CustomError {
    NOERROR(false,"ошибки нет"),
    IDISUSED(true,"Такой id уже занят"),
    NAMEISNULL(true,"Имя null"),
    IDISNULL(true,"поле id null"),
    COORDINATESISNULL(true,"поле coordinates null"),
    DATEISNULL(true,"поле date null"),
    AGEISNULL(true,"поле age null"),
    COLORISNULL(true,"поле color null"),
    DRAGONTYPEISNULL(true,"поле type null"),
    COORDXISNULL(true,"поле x null"),
    COORDYISNULL(true,"поле y null"),
    TOOTHCOUNTISNULL(true,"поле toothCount null"),
    NAMEISEMPTY(true,"имя пусто"),
    NEGATIVEAGE(true, "возраст меньше или равен 0"),
    NEGATIVEID(true,"id меньше или равен 0"),
    BIGX(true, "x слишком большой, должен быть меньше 41"),
    SMALLY(true, "y слишком маленький, должен быть больше -49"),
    PARSINGERROR(true,"Ошибка при парсинге ввода"),
    SPEAKINGISNULL(true,"поле speaking null"),
    NOSUCHCOLOR(true,"выбран цвет не из списка"),
    NOSUCHTYPE(true,"выбран тип не из списка");


    //false - валидация успешна, true - какой-то параметр неправилен
    private boolean isError;
    private String errorMessage;

    ValidateError(boolean isError,String errorMessage){
        setError(isError);
        setErrorMessage(errorMessage);
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return getErrorMessage();
    }
}
