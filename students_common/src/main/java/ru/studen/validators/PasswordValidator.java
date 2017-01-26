package ru.studen.validators;

/**
 * Валидатор пароля
 *
 * Package ru.rap.ru.students.common.validators
 * Class PasswordValidator implements IValidator
 *
 * @author Makarov Evgeny, 2017
 */
public class PasswordValidator implements IValidator
{
	private static final String PASSWORD_PATTERN =
			"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";

	public boolean validate(Object o)
	{
		if (o != null && o instanceof String) {
			String password = (String) o;
			return password.matches(PASSWORD_PATTERN);
		}
		return false;
	}
}
