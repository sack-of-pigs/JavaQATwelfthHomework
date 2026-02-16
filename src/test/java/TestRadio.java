import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestRadio {
    // Тест для конструктора с параметром

    @Test
    void testConstructorWithStationCount() {
        Radio radio = new Radio(5);
        assertEquals(5, radio.getStationCount());
        assertEquals(0, radio.getCurrentStation()); // Станция по умолчанию — 0
        assertEquals(0, radio.getVolume()); // Громкость по умолчанию — 0
    }

    // Тест для конструктора без параметров (по умолчанию 10 станций)

    @Test
    void testDefaultConstructor() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationCount());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getVolume());
    }

    // Существующие тесты (без изменений)

    @Test
    void testSetCurrentStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testSetCurrentStationBelowMin() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testSetCurrentStationAboveMax() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(10); // Для 10 станций максимум — 9
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testGetCurrentStation() {
        Radio radio = new Radio(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testSetVolume() {
        Radio radio = new Radio(10);
        radio.setVolume(50);
        assertEquals(50, radio.getVolume());
    }

    @Test
    void testSetVolumeBelowMin() {
        Radio radio = new Radio(10);
        radio.setVolume(-1);
        assertEquals(0, radio.getVolume());
    }

    @Test
    void testSetVolumeAboveMax() {
        Radio radio = new Radio(10);
        radio.setVolume(101);
        assertEquals(0, radio.getVolume());
    }

    @Test
    void testGetVolume() {
        Radio radio = new Radio(10);
        assertEquals(0, radio.getVolume());
    }

    // Тесты для методов увеличения и уменьшения громкости

    @Test
    void testIncreaseVolumeNormalCase() {
        Radio radio = new Radio(10);
        radio.setVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getVolume());
    }

    @Test
    void testIncreaseVolumeAtMaxShouldNotChange() {
        Radio radio = new Radio(10);
        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getVolume());
    }

    @Test
    void testDecreaseVolumeNormalCase() {
        Radio radio = new Radio(10);
        radio.setVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getVolume());
    }

    @Test
    void testDecreaseVolumeAtZeroShouldNotChange() {
        Radio radio = new Radio(10);
        radio.setVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getVolume());
    }
}
