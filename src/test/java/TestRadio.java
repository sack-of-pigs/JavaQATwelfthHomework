import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestRadio {
    private Radio radio = new Radio(); //Создаем поле с экземпляром класса Radio для использования его в тестах

    // Тесты для геттеров и сеттеров радиостанции

    @Test
    void testSetCurrentStation() {
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testSetCurrentStationBelowMin() {
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation()); // Должно остаться 0
    }

    @Test
    void testSetCurrentStationAboveMax() {
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation()); // Должно остаться 0
    }

    @Test
    void testGetCurrentStation() {
        assertEquals(0, radio.getCurrentStation());
    }

    // Тесты для геттеров и сеттеров громкости

    @Test
    void testSetVolume() {
        radio.setVolume(50);
        assertEquals(50, radio.getVolume());
    }

    @Test
    void testSetVolumeBelowMin() {
        radio.setVolume(-1);
        assertEquals(0, radio.getVolume()); // Должно остаться 0
    }

    @Test
    void testSetVolumeAboveMax() {
        radio.setVolume(101);
        assertEquals(0, radio.getVolume()); // Должно остаться 0
    }

    @Test
    void testGetVolume() {
        assertEquals(0, radio.getVolume());
    }

    // Тесты для метода next()

    @Test
    void testNextNormalCase() {
        radio.setCurrentStation(3);
        radio.next();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void testNextAtMaxShouldResetToZero() {
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    // Тесты для метода prev()

    @Test
    void testPrev() {
        radio.setCurrentStation(3);
        radio.prev();
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void testPrevAtZeroShouldGoToNine() {
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    // Тесты для метода increaseVolume()

    @Test
    void testIncreaseVolume() {
        radio.setVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getVolume());
    }

    @Test
    void testIncreaseVolumeAtMaxShouldNotChange() {
        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getVolume());
    }

    // Тесты для метода decreaseVolume()

    @Test
    void testDecreaseVolume() {
        radio.setVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getVolume());
    }

    @Test
    void testDecreaseVolumeAtZeroShouldNotChange() {
        radio.setVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getVolume());
    }
}
