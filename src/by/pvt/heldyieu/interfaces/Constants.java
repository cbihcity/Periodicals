package by.pvt.heldyieu.interfaces;

public interface Constants {
	String ERROR_CLOSING_RESULTSET = "Произошла ошибка при попытке закрыть результирующий поток данных. Подробнее в логе log.txt";
	String ERROR_SQL_EXECUTE = "Произошла ошибка при выполнении запроса. Подробнее в логе log.txt";
	String ERROR_DELETE_RESULTSET = "Произошла ошибка при выполнении операции удаления. Подробнее в логе log.txt";
	String ERROR_CREATE_RESULTSET = "Произошла ошибка при выполнении операции создания. Подробнее в логе log.txt";
	String ERROR_UPDATE_RESULTSET = "Произошла ошибка при выполнении операции обновления. Подробнее в логе log.txt";
	String ERROR_INTEGRITY_CONSTRAINT_VIOLATION = "Дублирование значения поля таблицы. Подробнее в логе log.txt";
	String ERROR_GET_ID = "Ошибка при создании пользователя. Не получен ID. Подробнее в логе log.txt";
	String INVALID_PARSER_PARAMETER = "Неверно задан параметр для создания daoImpl";
	String MAGAZINE_DAO = "magazineDao";
	String USER_DAO = "userDao";
	String SUBSCRIPTION_DAO = "subscriptionDao";
	String SUBSCRIPTION_TYPE_DAO = "subscriptionTypeDao";
}
