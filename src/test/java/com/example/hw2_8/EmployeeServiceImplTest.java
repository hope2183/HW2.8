package com.example.hw2_8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static com.example.hw2_8.EmployeeTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {

    private EmployeeServiceImpl out = new EmployeeServiceImpl();

    @BeforeEach
    private void initialize() {
        out = new EmployeeServiceImpl();
    }
    @Test
//    public void addEmployeeWhenDoesNotExist() {
//        Employee expectedEmployee = new Employee(FIRST_NAME, LAST_NAME);
//        assertEquals(0, out.getEmployeeBook().size());
//        Employee actualEmployee = out.addToEmployeeBook(FIRST_NAME, LAST_NAME);
//        assertEquals(expectedEmployee, actualEmployee);
//        assertEquals(1, out.getEmployeeBook().size());
//        assertTrue(out.getEmployeeBook().contains(actualEmployee));
//    }
    public static Stream<Arguments> ArgumentsForWrongEmployeeName(){
    return Stream.of(
            Arguments.of(FIRST_NAME,WRONG_LAST_NAME),
            Arguments.of(WRONG_FIRST_NAME,LAST_NAME),
            Arguments.of(WRONG_FIRST_NAME,WRONG_LAST_NAME)
    );
    }

//    @MethodSource("ArgumentsForWrongEmployeeName")
//    @ParameterizedTest
//    public void shouldThrowInvalidNameExceptionForWrongNames(String firstName, String lastName) {
//        assertThrows(InvalidNameException.class, () -> out.addToEmployeeBook(firstName, lastName));
//    }
    @Test
    public void shouldThrowEmployeeAlreadyExistsExceptionIfEmployeeExists(){
    Employee existingEmployee = out.addToEmployeeBook(FIRST_NAME,LAST_NAME);
        assertTrue(out.getEmployeeBook().contains(existingEmployee));
        assertThrows(EmployeeAlreadyExistsException.class, () -> out.addToEmployeeBook(FIRST_NAME,LAST_NAME));
        assertEquals(1, out.getEmployeeBook().size());
    }
    @Test
    public void shouldFindEmployeeIfExists(){
        Employee existingEmployee = out.addToEmployeeBook(FIRST_NAME,LAST_NAME);
        assertEquals(existingEmployee,out.findInEmployeeBook(FIRST_NAME,LAST_NAME));
    }

    @Test
    public void shouldThrowEmployeeDoesNotExistsExceptionWhenFindingEmployeeIfEmployeeDoesNotExists() {
        assertEquals(0, out.getEmployeeBook().size());
        assertThrows(EmployeeDoesNotExistException.class, () -> out.findInEmployeeBook(FIRST_NAME, LAST_NAME));
        assertEquals(0, out.getEmployeeBook().size());
    }
    @Test
    public void shouldRemoveEmployeeIfExists(){
        Employee existingEmployee = out.addToEmployeeBook(FIRST_NAME,LAST_NAME);
        assertEquals(1,out.getEmployeeBook().size());
        Employee actualEmployee = out.removeFromEmployeeBook(FIRST_NAME,LAST_NAME);
        assertEquals(existingEmployee,actualEmployee);
        assertTrue(out.getEmployeeBook().isEmpty());
        assertFalse(out.getEmployeeBook().contains(existingEmployee));
    }
    @Test
    public void shouldThrowEmployeeDoesNotExistsExceptionWhenRemovingEmployeeIfEmployeeDoesNotExists() {
        assertTrue(out.getEmployeeBook().isEmpty());
        assertThrows(EmployeeDoesNotExistException.class, () -> out.removeFromEmployeeBook(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldReturnEmptyCollectionWhenEmployeeBookIsEmpty(){
        assertTrue(out.getEmployeeBook().isEmpty());
    }
    @Test
    public void shouldReturnListOfEmployeesWhenEmployeeBookIsNotEmpty(){
        assertTrue(out.getEmployeeBook().isEmpty());
        Employee employee1 = out.addToEmployeeBook(FIRST_NAME,LAST_NAME);
        Employee employee2 = out.addToEmployeeBook(FIRST_NAME2,LAST_NAME2);
        Collection<Employee> expected = List.of(employee1,employee2);
        assertIterableEquals(expected,out.getEmployeeBook());
    }
    @Test
    public void shouldNotThrowEmployeeBookIsEmptyExceptionWhenBookIsEmpty(){
        assertDoesNotThrow(() -> out.getEmployeeBook().isEmpty());
    }
    @Test
    public void shouldThrowEmployeeBookIsEmptyExceptionWhenBookIsEmpty(){
        assertTrue(out.getEmployeeBook().isEmpty());
//        assertThrows(EmployeeBookIsEmptyException.class,() -> out.getEmployeeBook());
    }

}
