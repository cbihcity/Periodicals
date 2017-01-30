package by.pvt.heldyieu.dao.generic;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T, PK extends Serializable> {
	
	 /** ������� ����� ������ � ��������������� �� ������ */
    public T create();

    /** ������� ����� ������, ��������������� ������� object */
    public T persist(T object);

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    public T getByPK(PK key);

    /** ��������� ��������� ������� group � ���� ������ */
    public void update(T object);

    /** ������� ������ �� ������� �� ���� ������ */
    public void delete(T object);

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    public List<T> getAll();
}
