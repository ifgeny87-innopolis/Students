package ru.studen.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.studen.common.Messages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created in project RiddlesAndPuzzles in 26.12.2016
 */
public abstract class BaseController
{
	// logger
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);

	private String path;

	HttpServletRequest request;

	HttpServletResponse response;

	Model model;

	private String sessionId;

	String getSessionId()
	{
		return sessionId;
	}

	/**
	 * Инициализатор запроса
	 * Запоминает Request и Response чтобы потом удобней было к ним обращаться.
	 * Также запоминает sessionId, потому что с ним придется много работать.
	 *
	 * !!! Важно:
	 * Если вызов не для контроллера класса UserController, то проверяет авторизацию.
	 */
	@ModelAttribute
	public void init(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception
	{
		this.request = request;
		this.response = response;
		this.model = model;
		this.sessionId = request.getRequestedSessionId();

		// чтобы получить UTF-8 из request
		// работает только для POST данных
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("Сорвалась настройка кодировки для объекта Request:\n" + e.getMessage(), e);
		}

		// корень приложения
		request.setAttribute("PATH", this.path = request.getContextPath());
	}

	protected final String redirectTo(String page_name)
	{
		return "redirect:/" + page_name;
	}

	protected final void reportError(int statusCode, int errorCode)
	{
		model.addAttribute("status_code", statusCode);
		model.addAttribute("error_message", Messages.get(errorCode));
	}

	/**
	 * Ловушка для ошибок
	 * @param ex
	 * @return
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex)
	{
		Map<String, Object> model = new HashMap<>();
		model.put("exception_class", ex.getClass());
		model.put("exception_message", ex.getMessage());
		model.put("exception_trace", Arrays
				.stream(ex.getStackTrace())
				.map(t -> "call <b>" + t.getMethodName() + "</b> from <i>" + t.getFileName() + ":" + t.getLineNumber() + "</i>")
				.collect(Collectors.joining("<br/>"))
				.toString());
		return new ModelAndView("error", model);
	}
}
