package ru.studen.pojo;

/**
 * Created in project students on 26.01.17
 */
public class RolePojo
{
	private final Long id;

	private final String name;

	public RolePojo(Long id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public Long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}
}
