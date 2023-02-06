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
        //given
        int expected = 100;

        //when
        int result = carList.size();

        //then
        assertEquals(expected, result);
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        //given
        int expected = 99;

        //when
        assertTrue(carList.removeAt(5));
        int result = carList.size();

        //then
        assertEquals(expected, result);
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        //given
        int expectedBeforeDelete = 101;
        int expectedAfterDelete = 100;

        //when
        Car car = new Car("Volvo", 15);
        carList.add(car);
        assertEquals(expectedBeforeDelete, carList.size());
        assertTrue(carList.remove(car));
        int result = carList.size();

        //then
        assertEquals(expectedAfterDelete, result);
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        //given
        int expected = 100;

        //when
        Car car = new Car("Volvo", 15);
        assertFalse(carList.remove(car));
        int result = carList.size();

        //then
        assertEquals(expected, result);
    }

    @Test
    public void whenListClearedThenSizeMustBeZero() {
        //given
        int expected = 0;

        //when
        carList.clear();
        int result = carList.size();

        //then
        assertEquals(expected, result);
    }


    @Test
    public void methodGetReturnedRightValue(){
        //given
        String expected = "Brand0";

        //when
        Car car = carList.get(0);
        String result = car.getBrand();

        //then
        assertEquals(expected, result);
    }
}