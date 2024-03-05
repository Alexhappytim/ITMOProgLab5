package collectionManager;

public enum ValidateError {
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
    TOOTHCOUNTISNULL(true,"поле toothCount null"),
    NAMEISEMPTY(true,"имя пусто"),
    NEGATIVEAGE(true, "возраст меньше или равен 0"),
    NEGATIVEID(true,"id меньше или равен 0"),
    BIGX(true, "x слишком большой, должен быть меньше 41"),
    SMALLY(true, "y слишком маленький, должен быть больше -49");

    //false - валидация успешна, true - какой-то параметр неправилен
    private boolean isError;
    private String errorMessage;

    ValidateError(boolean isError,String errorMessage){
        setError(isError);
        setErrorMessage(errorMessage);
    }

    public boolean isError() {
        return isError;
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

}
