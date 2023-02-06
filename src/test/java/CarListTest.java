import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {
    private CarList carList;

    @BeforeEach
    public void setUp() throws Exception {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsWhenSizeMustBe100() {
        int expected = 100;
        int result = carList.size();
        assertEquals(expected, result);
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        int expected = 99;

        assertTrue(carList.removeAt(5));
        int result = carList.size();
        assertEquals(expected, result);
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        int expectedBeforeDelete = 101;
        int expectedAfterDelete = 100;

        Car car = new Car("Volvo", 15);
        carList.add(car);

        assertEquals(expectedBeforeDelete, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(expectedAfterDelete, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        int expected = 100;

        Car car = new Car("Volvo", 15);
        assertFalse(carList.remove(car));
        int result = carList.size();

        assertEquals(expected, result);
    }

    @Test
    public void whenListClearedThenSizeMustBeZero() {
        int expected = 0;
        carList.clear();
        int result = carList.size();

        assertEquals(expected, carList.size());
    }


    @Test
    public void methodGetReturnedRightValue(){
        String expected = "Brand0";
        Car car = carList.get(0);
        assertEquals(expected, car.getBrand());
    }
}