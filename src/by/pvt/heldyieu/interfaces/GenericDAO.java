package by.pvt.heldyieu.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <T, PK extends Number> {
	
    /** ������� ����� ������, ��������������� ������� object */
    public T create(T object) throws SQLException;

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    public T getByPK(PK key) throws SQLException;

    /** ��������� ��������� ������� group � ���� ������ */
    public void update(T object) throws SQLException;

    /** ������� ������ �� ������� �� ���� ������ */
    public void delete(T object) throws SQLException;

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    public List<T> getAll() throws SQLException;
}